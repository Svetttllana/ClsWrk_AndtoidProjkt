package com.example.clswrk_androidprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //переход по неявному интенту на 1 активити
        val btnGoToActivity1 = findViewById<Button>(R.id.btnGoToActivity1)
        btnGoToActivity1.setOnClickListener {
            startActivity(Intent("android.intent.action.OPEN_ACTIVITY1"))
        }
    }
}