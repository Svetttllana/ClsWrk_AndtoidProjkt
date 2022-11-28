package com.example.clswrk_androidprojekt.listener

import android.widget.ImageView

interface ItemsListener {

    fun onClick()



    fun onElementSelected(name:String , date:String , imageView:Int)

}