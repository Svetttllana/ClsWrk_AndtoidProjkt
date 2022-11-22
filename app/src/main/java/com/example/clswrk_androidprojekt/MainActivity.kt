package com.example.clswrk_androidprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.clswrk_androidprojekt.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)
        btnGoToActivity2.setOnClickListener {
            startActivity(
                Intent(this, MainActivity2::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
            //MainActivity2  не будет добавлена в бекстек
            //.addFlags(Intent.FLAG_Activity_NO_HISTORY
            startMainActivity2(this,"Svetlana")

            val textView = findViewById<TextView>(R.id.textView)
            val btn = findViewById<Button>(R.id.btnClickMe)
            btn.setOnClickListener {
                textView.text = getString(R.string.you_click_on_second_button)
                startMainActivity2(
                    this,
                    textView.text.toString() + getString(R.string.from_MainActivity)
                )


            }




        }
    }
}



// Entent Extras;  передаем какие-то маленькие данные
//            val intent = Intent(this, MainActivity2::class.java)
//            intent.putExtra("Sv", "Hello")
//            startActivity(intent)