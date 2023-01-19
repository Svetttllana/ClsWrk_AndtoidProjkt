package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor (
    private val itemsRepository: ItemsRepository)
{
   suspend fun getData():List<ItemsModel>{
        return   itemsRepository.getData()
    }
}