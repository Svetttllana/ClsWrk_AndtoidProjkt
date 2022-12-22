package com.example.clswrk_androidprojekt.presentation.view.home

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsView {

    fun ItemasReceived(itemsList:List<ItemsModel>)

    fun imageViewClicked(msg:Int)

    fun itemClick(navigateData: NavigateWithBundle){


    }



}