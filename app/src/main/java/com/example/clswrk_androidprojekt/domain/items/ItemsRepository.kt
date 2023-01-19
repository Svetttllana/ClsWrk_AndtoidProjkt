package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsRepository {

  suspend fun getData():List<ItemsModel>
}