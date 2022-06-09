package com.hy0417sage.androidprojects.secretdairy

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private val openButton: Button by lazy {
        findViewById(R.id.openButton)
    }

    private val changePasswordButton: Button by lazy {
        findViewById(R.id.changePasswordButton)
    }

    private val numberPicker1: NumberPicker by lazy {
        findViewById<NumberPicker?>(R.id.numberPicker1)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker2: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker2)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker3: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker3)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }

    private var changePasswordMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1
        numberPicker2
        numberPicker3

        openButton.setOnClickListener {
            if (changePasswordMode) {
                Toast.makeText(this, "비밀번호 변경 중입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Preference 를 다른 앱들과 공유해서 사용하고 싶지 않을 시에 MODE_PRIVATE 으로 설정해준다.
            val passwordPreference = getSharedPreferences("password", Context.MODE_PRIVATE)

            val passwordFromUser =
                "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

            if (passwordPreference.getString("password", "000").equals(passwordFromUser)) {
                // 입력 값이 같으면 패스워드 성공
                // TODO 다이어리 페이지 작성후에 넘겨 주어야 함
            } else {
                // 실패
                showErrorAlertDialog()
            }
        }

        changePasswordButton.setOnClickListener {

            val passwordPreference = getSharedPreferences("password", Context.MODE_PRIVATE)
            val passwordFromUser =
                "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

            // 다른 작업을 할 수 없게 예외 처리를 해준다.
            if (changePasswordMode) {
                // 번호를 저장하는 기능
                passwordPreference.edit {
                    putString("password", passwordFromUser)
                }
                changePasswordMode = false
                changePasswordButton.setBackgroundColor(Color.BLACK)
            } else {

                // changePasswordMode 가 활성화
                if (passwordPreference.getString("password", "000").equals(passwordFromUser)) {
                    changePasswordMode = true
                    Toast.makeText(this, "변경할 패스워드를 입력해 주세요.", Toast.LENGTH_SHORT).show()
                    changePasswordButton.setBackgroundColor(Color.RED)
                } else {
                    // 실패
                    showErrorAlertDialog()
                }
            }
        }
    }

    private fun showErrorAlertDialog(){
        AlertDialog.Builder(this)
            .setTitle("실패")
            .setMessage("비밀번호가 잘못 되었습니다.")
            .setPositiveButton("확인") { _, _ -> } //굳이 코드로 작성하지 않아도 되는 불필요한 코드는 _로 처리해주면 된다.
            .create()
            .show()
    }
}