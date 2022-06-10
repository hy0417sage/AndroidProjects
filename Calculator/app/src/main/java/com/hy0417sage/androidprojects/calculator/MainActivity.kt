package com.hy0417sage.androidprojects.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val expressionTextView: TextView by lazy{
        findViewById<TextView>(R.id.expressionTextView)
    }

    private val resultTextView: TextView by lazy{
        findViewById<TextView>(R.id.resultTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {
        when (view.id) {
            R.id.button0 -> numberButtonClicked("0")
            R.id.button1 -> numberButtonClicked("1")
            R.id.button2 -> numberButtonClicked("2")
            R.id.button3 -> numberButtonClicked("3")
            R.id.button4 -> numberButtonClicked("4")
            R.id.button5 -> numberButtonClicked("5")
            R.id.button6 -> numberButtonClicked("6")
            R.id.button7 -> numberButtonClicked("7")
            R.id.button8 -> numberButtonClicked("8")
            R.id.button9 -> numberButtonClicked("9")
            R.id.buttonDivider -> operatorButtonClicked("/")
            R.id.buttonMinus -> operatorButtonClicked("-")
            R.id.buttonModulo -> operatorButtonClicked("%")
            R.id.buttonPlus -> operatorButtonClicked("+")
            R.id.buttonMulti -> operatorButtonClicked("*")
        }
    }

    private fun numberButtonClicked(number: String) {
        val expressionText = expressionTextView.text.split(" ")
        if (expressionText.isNotEmpty() && expressionText.last().length >= 15){
            Toast.makeText(this, "15자리 까지만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun operatorButtonClicked(operator: String) {

    }

    fun clearButtonClicked(view: View) {

    }

    fun historyButton(view: View) {}

    fun resultButtonClicked(view: View) {}
}