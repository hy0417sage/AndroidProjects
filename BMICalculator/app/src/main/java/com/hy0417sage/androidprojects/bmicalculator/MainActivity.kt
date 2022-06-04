package com.hy0417sage.androidprojects.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //부모 생성자를 부른다.
        setContentView(R.layout.activity_main) //이 액티비티의 컨텐츠 뷰로 사용하겠다. R.으로 주소를 치환해서 해당 뷰를 불러올 수 있다.

        //리소스파일에 있는 컴포넌트와 Kotlin 파일을 연결한다. (option + enter)으로 정의 되어있지 않은 파일을 import 할 수 있다.
        val heightEditText : EditText = findViewById(R.id.heightEditText) //T!를 반환하는데 느낌포는 절대로 null이 될수 없다는 타입이라는 뜻이다.
        val weightEditText = findViewById<EditText>(R.id.weightEditText) //명시적으로 EditText를 <>표시를 통해 반환한다는걸 알려준다.
        val resultButton : Button = findViewById(R.id.resultButton)

        //인터페이스를 구현해주는 방법, 코틀린에서는 람다 형식으로 구현할수 있음
        resultButton.setOnClickListener {
            Log.d("MainActivity", "ResultButton이 클릭되었습니다.")

            //빈값 예외처리 해준다.
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener //해당 setOnClickListener하는 함수를 나간다. (return 한다.)
            }

            //이 아래로는 절대 빈 값이 올 수 없음.
            val height : Int = heightEditText.text.toString().toInt() //값을 Int로 치환
            val weight : Int = weightEditText.text.toString().toInt()
            Log.d("MainActivity", "height : $height, weight : $weight")

            //다음 페이지에 결과를 나오게 한다.
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent) //ResultActivity로 넘어가고 싶어 라고 선언된 Intent를 실행한다.
        }

    }
}