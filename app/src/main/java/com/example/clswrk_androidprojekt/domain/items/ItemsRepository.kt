package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.example.clswrk_androidprojekt.domain.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface  ItemsRepository {

 fun getData():Completable

 fun showData():Observable<List<ItemsModel>>

  suspend fun deliteItemByDescription(description: String)

  suspend fun findItemByDescription(searchText:String): ItemsModel

  suspend fun favClicked(itemsModel: ItemsModel,isFavorite:Boolean)

  suspend fun getFavorites():List<FavoriteModel>
}