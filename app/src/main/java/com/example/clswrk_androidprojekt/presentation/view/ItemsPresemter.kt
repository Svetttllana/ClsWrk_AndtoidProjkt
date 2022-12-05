package com.example.clswrk_androidprojekt.presentation.view

import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.ItemsInteractor
import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsPresemter(private val itemsView: ItemsView,
private val itemsInteractor: ItemsInteractor) {


    fun getData(){
       val listItems= itemsInteractor.getData()
        itemsView.dataReceived(listItems)



        itemsView.dataReceived(listItems)


    }

    fun imageViewClicked(){
        itemsView.imageViewClicked(R.string.imageview_clicked)

    }

 fun elementSelected(name: String, date: String, imageView: Int){
     itemsView.goToDetails(name,date,imageView)


 }


}