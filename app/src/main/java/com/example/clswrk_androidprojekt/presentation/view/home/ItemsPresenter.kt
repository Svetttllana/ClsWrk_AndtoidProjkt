package com.example.clswrk_androidprojekt.presentation.view.home

import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.items.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

    private lateinit var itemsView: ItemsView

    fun setview(itemsFragment: ItemsFragment) {

        itemsView = itemsFragment
    }

    fun getItems() {
        val items = itemsInteractor.getData()
        itemsView.ItemasReceived(items)

    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.image_view_clicked)
    }

    fun itemClicked(name: String, date: String, imageView: Int) {
        itemsView.itemClick(NavigateWithBundle(name = name, date = date, image = imageView))


    }

}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String

)