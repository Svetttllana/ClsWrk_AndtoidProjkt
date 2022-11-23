package com.example.clswrk_androidprojekt

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //создали стрелочку назад
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = " New Title. Main Activity 2"
        val btnGoToActivity3 = findViewById<Button>(R.id.btnGoToActivity3)
        btnGoToActivity3.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))


// получаем
            val intentExtras = intent.extras?.get("SVET")
            Toast.makeText(this, "$intentExtras", Toast.LENGTH_SHORT).show()
        }


    }

        companion object {

            private const val SVET = "SVET"

            fun startMainActivity2(context: Context, string: String) {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra(SVET, string)
                context.startActivity(intent)
            }
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            android.R.id.home -> onBackPressed()
            R.id.close -> finishAffinity()
            R.id.goBack -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }



    }
