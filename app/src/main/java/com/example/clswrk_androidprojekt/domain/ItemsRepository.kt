package com.example.clswrk_androidprojekt.domain

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsRepository {
    fun getData():List<ItemsModel>
}