package com.example.clswrk_androidprojekt.domain

import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData():List<ItemsModel>{
    return    itemsRepository.getData()

    }

}