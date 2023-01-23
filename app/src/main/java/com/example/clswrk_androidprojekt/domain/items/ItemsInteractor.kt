package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor (
    private val itemsRepository: ItemsRepository)
{
   suspend fun getData(){
        return   itemsRepository.getData()
    }

    suspend fun showData():List<ItemsModel>{
        return  itemsRepository.showData()
    }

    suspend fun deliteItemByDescription(description: String){
        itemsRepository.deliteItemByDescription(description)


    }

    suspend fun findItem(searchText:String):ItemsModel{
      return  itemsRepository.findItemByDescription(searchText)


    }

}