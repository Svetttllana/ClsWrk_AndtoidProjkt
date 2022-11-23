package com.example.clswrk_androidprojekt

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast


class KotlinActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        val btn = findViewById<Button>(R.id.btn)
//у класса может быть свойство и поведение/

        val person = object{
            val name = "Svetochka"
            fun develop(){
                // а тут мы логируем и передаем в logCat
                Log.w("Anonime class","Called develop fun")
            }
        }

        val person2 = object:Developer {
            val name = "Katya"
            override fun develop() {
                Log.w("Anonym class","Called develop fun DEVELOPER" )
            }
        }

val house = HouseBuilder.Builder
    .setStock(3)
    .setSwimpool(false)
    .build()




//тут по нажатию на кнопку будет выплывать тост  с нэймом
        btn.setOnClickListener {

            Log.w("houseBuilder","${house.hasSwimpool()} ${house.howManyStocks()}" )
            person.develop()
            person2.name
            person2.develop()
            callAnonymClass(person2)
Toast.makeText(this,person.name,Toast.LENGTH_SHORT).show()
        }

        makeRequest("https://googl.com/"){callBackResult->
           Log.w("callBack result", callBackResult)
        }
    }

fun callAnonymClass(developer: Developer){
    developer.develop()

}



fun makeRequest(url:String,argForCallBack:(string:String)->Unit){
argForCallBack.invoke("callBAckResult from methood $url")
}



//        val lambda = {string:String -> Toast.makeText(this, " your text is", //$string",
//            Toast.LENGTH_SHORT).show()

      //  lambda("Set text in lambda")



    companion object {
        fun kotlinActivityStart(context: Context) {
            context.startActivity(Intent(context, KotlinActivity::class.java))
        }
    }


}




interface Developer{

    fun develop()
}