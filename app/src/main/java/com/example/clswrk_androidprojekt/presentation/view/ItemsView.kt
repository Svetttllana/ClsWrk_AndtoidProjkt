package com.example.clswrk_androidprojekt.presentation.view

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewClicked(msg:Int)

    fun goToDetails(name: String, date: String, imageView: Int)

}