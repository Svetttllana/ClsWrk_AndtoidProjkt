package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.example.clswrk_androidprojekt.domain.model.ItemsModel

interface ItemsRepository {

  suspend fun getData()

  suspend fun showData():List<ItemsModel>

  suspend fun deliteItemByDescription(description: String)

  suspend fun findItemByDescription(searchText:String): ItemsModel

  suspend fun favClicked(itemsModel: ItemsModel)

  suspend fun getFavorites():List<FavoriteModel>
}