package com.hy0417sage.androidprojects.bmicalculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity(){

    //액티비티의 시작점 : onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0) //데이터가 넘어오지 않았을 경우 0기본값을 갖는다.
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height, weight : $weight")

        val bmi = weight / (height / 100.0).pow(2.0) //2제곱근
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val bmiResultTextView = findViewById<TextView>(R.id.BMIResultTextView)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        bmiResultTextView.text = bmi.toString()
        resultTextView.text = resultText
    }

}