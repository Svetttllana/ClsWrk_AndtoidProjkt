package com.example.clswrk_androidprojekt.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor (private val itemsRepository: ItemsRepository)
{
    fun getData():List<ItemsModel>{
        return   itemsRepository.getData()
    }
}