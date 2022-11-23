package com.example.clswrk_androidprojekt

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.clswrk_androidprojekt.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#5d6393")))
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.teal_700)))
        supportActionBar?.title = "Svetochka"



        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)
        btnGoToActivity2.setOnClickListener {
            startActivity(
                Intent(this, MainActivity2::class.java)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
            //MainActivity2  не будет добавлена в бекстек
            //.addFlags(Intent.FLAG_Activity_NO_HISTORY
            startMainActivity2(this,"Svetlana")

            val textView2 = findViewById<TextView>(R.id.textView)
            val btn = findViewById<Button>(R.id.btnClickMe)
            btn.setOnClickListener {
                textView2.text = getString(R.string.you_click_on_second_button)
                startMainActivity2(
                    this,
                    textView2.text.toString()
                )


            }




        }
    }
}



// Entent Extras;  передаем какие-то маленькие данные
//            val intent = Intent(this, MainActivity2::class.java)
//            intent.putExtra("Sv", "Hello")
//            startActivity(intent)