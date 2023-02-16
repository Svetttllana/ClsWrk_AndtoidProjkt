package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.example.clswrk_androidprojekt.domain.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsInteractor @Inject constructor (
    private val itemsRepository: ItemsRepository){
 fun getData():Completable{
         return  itemsRepository.getData()
    }

 fun showData(): Observable<List<ItemsModel>> {
     return itemsRepository.showData()
    }

    suspend fun deliteItemByDescription(description: String){
        itemsRepository.deliteItemByDescription(description)


    }

    suspend fun findItem(searchText:String): ItemsModel {
      return  itemsRepository.findItemByDescription(searchText)
    }


    suspend fun onFavClicked(description:String,isFavorite:Boolean){
        val foundItem = findItem(description)
        itemsRepository.favClicked(foundItem,isFavorite)

    }

    suspend fun getFavorites():List<FavoriteModel>{
        return itemsRepository.getFavorites()
    }

}