package com.hy0417sage.androidprojects.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {

    }

    fun clearButtonClicked(view: View) {

    }

    fun historyButton(view: View) {}
    fun resultButtonClicked(view: View) {}
}