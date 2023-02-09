package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.example.clswrk_androidprojekt.domain.model.ItemsModel
import kotlinx.coroutines.flow.Flow

interface  ItemsRepository {

  suspend fun getData()

  suspend fun showData(): Flow<List<ItemsModel>>

  suspend fun deliteItemByDescription(description: String)

  suspend fun findItemByDescription(searchText:String): ItemsModel

  suspend fun favClicked(itemsModel: ItemsModel,isFavorite:Boolean)

  suspend fun getFavorites():List<FavoriteModel>
}