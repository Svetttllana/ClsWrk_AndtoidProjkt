package com.example.clswrk_androidprojekt.presentation.view.adapter.listener

import android.widget.ImageView

interface ItemsListener {

    fun onClick()



    fun onElementSelected(name:String , date:String , imageView:Int)

}