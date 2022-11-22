package com.example.clswrk_androidprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)
        btnGoToActivity2.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            //MainActivity2  не будет добавлена в бекстек
                //.addFlags(Intent.FLAG_Activity_NO_HISTORY
        }
    }
}


//    override fun onStart() {
//        super.onStart()
//        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
//    }
//}