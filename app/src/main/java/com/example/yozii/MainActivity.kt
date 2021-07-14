package com.example.yozii

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start (view: View) {
        val startButton : Button = findViewById(R.id.startButton)
        intent = Intent(
            applicationContext,
            textChoice::class.java
        )
        startActivity(intent)
    }
}