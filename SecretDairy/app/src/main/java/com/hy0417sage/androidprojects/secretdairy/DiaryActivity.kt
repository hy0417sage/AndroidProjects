package com.hy0417sage.androidprojects.secretdairy

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity: AppCompatActivity() {

    //핸들러 : 쓰레드를 열었을 때 UI 쓰레드를 연결해줌
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val diaryEditText = findViewById<EditText>(R.id.diaryEditText)
        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

        diaryEditText.setText(detailPreferences.getString("detail", ""))

        //백그라운드 에서 저장
        val runnable = Runnable{
            getSharedPreferences("diary", Context.MODE_PRIVATE).edit{
                //잠깐 멈췄을때 저장하기
                putString("detail", diaryEditText.text.toString())
            }
        }

        diaryEditText.addTextChangedListener {
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, 500)
        }
    }


}