package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsRepository {

  suspend fun getData()

  suspend fun showData():List<ItemsModel>

  suspend fun deliteItemByDescription(description: String)

  suspend fun findItemByDescription(searchText:String):ItemsModel

}