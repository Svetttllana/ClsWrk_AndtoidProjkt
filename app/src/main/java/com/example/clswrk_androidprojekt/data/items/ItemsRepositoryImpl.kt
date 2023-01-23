package com.example.clswrk_androidprojekt.data.items

import android.util.Log
import androidx.lifecycle.Transformations.map
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.data.ApiService
import com.example.clswrk_androidprojekt.data.ApiServiceSecond
import com.example.clswrk_androidprojekt.data.database.ItemsEntity
import com.example.clswrk_androidprojekt.data.database.dao.ItemsDAO
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

import javax.inject.Inject
import javax.inject.Named


class ItemsRepositoryImpl @Inject constructor(
    @Named("FIRST") private val apiService: ApiService,
    @Named("SECOND") private val apiServiceSecond: ApiServiceSecond,
    private val itemsDAO: ItemsDAO
) : ItemsRepository {
    override suspend fun getData() {

        return withContext(Dispatchers.IO) {
            if (!itemsDAO.doesItemsEntityExist()) {
                Log.w("getData","data not exists")


                val response = apiService.getData()
                response.body()?.sampleList?.let {
                    it.map {
                        val itemsEntity =
                            ItemsEntity(Random().nextInt(), it.description, it.imageUrl)
                        itemsDAO.insertItemsEntity(itemsEntity)

                    }
                }
            }


        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map {
                ItemsModel(it.description, it.imageUrl)
            }
        }
    }

    override suspend fun deliteItemByDescription(description: String) {
        withContext(Dispatchers.IO){
            itemsDAO.deliteItemEntityByDescription(description)
        }
    }

    override suspend fun findItemByDescription(searchText: String): ItemsModel {
//        return with(Dispatchers.IO){
//            val itemsEntity = itemsDAO.findItementityByDescription(searchText)
//        }
    }
}

