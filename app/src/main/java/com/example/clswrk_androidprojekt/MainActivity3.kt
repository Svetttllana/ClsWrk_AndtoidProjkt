package com.example.clswrk_androidprojekt

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.clswrk_androidprojekt.KotlinActivity.Companion.kotlinActivityStart
import com.google.android.material.textfield.TextInputLayout



class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //переход по неявному интенту на 1 активити
        val btnGoToActivity1 = findViewById<Button>(R.id.btnGoToActivity1)
        btnGoToActivity1.setOnClickListener {
            startActivity(Intent("android.intent.action.OPEN_ACTIVITY1"))
        }

        val image = findViewById<ImageView>(R.id.ImageView)
            val editTextLog = findViewById<EditText>(R.id.EdTextLogin)
            val editText2Passw = findViewById<EditText>(R.id.EdTextPassword)
            val btDisplayText = findViewById<Button>(R.id.displayBtn)
            val textView = findViewById<TextView>(R.id.tv_text)
            // тут должно быть 2 лэйаута
            val LoginLay = findViewById<TextInputLayout>(R.id.layoutLogin)
            val PasswordLay = findViewById<TextInputLayout>(R.id.layoutPassword)



        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)

        // сделали так, чтобы клик был только на одной радиоБаттон

        rb1.setOnClickListener {
            if (rb1.isChecked) {
                image.setImageResource(R.drawable.cat_inage)
                rb2.isChecked = false

            } else {
                rb1.isChecked = true

            }
        }
        rb2.setOnClickListener {

            if (rb2.isChecked) {

                rb1.isChecked = false
            } else {
                rb2.isChecked = true
            }

        }

        btDisplayText.setOnClickListener {
            // dialog.show()
            // надо попробовать сделать и с текст ерор и с лэйаут ерор в одном из них будет выпадать картинка по умолчанию,
            // а в другом та картинка, которую мы поставили



            if (editTextLog.text.toString().isEmpty()) {
                editTextLog.error = getString(R.string.LogCantBeEmpty)
            } else if (editText2Passw .text.toString().isEmpty()) {
                editText2Passw .error = getString(R.string.PassCantBeEmpty)
            } else {

                kotlinActivityStart(this)
                textView.text = "${editTextLog.text.toString()} ${editText2Passw .text.toString()}"

            }
            val dialog = AlertDialog.Builder(this)
                .setTitle("Information")
                .setMessage("Login:" + "${editTextLog.text.toString()} " + "Password:" +"\n ${editText2Passw.text.toString()}")
                .setCancelable(true)
                .setPositiveButton("Ok") { dialog, _ ->
                    dialog.cancel()}
                .setNegativeButton("cancel") {dialog, _ -> dialog.cancel()}
            dialog.show()
        }
    }
}
