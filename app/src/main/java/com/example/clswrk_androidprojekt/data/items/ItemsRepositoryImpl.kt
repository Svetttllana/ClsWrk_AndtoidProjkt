package com.example.clswrk_androidprojekt.data.items

import android.util.Log
import com.example.clswrk_androidprojekt.data.api.ApiService
import com.example.clswrk_androidprojekt.data.api.ApiServiceSecond
import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.data.database.ItemsEntity
import com.example.clswrk_androidprojekt.data.database.dao.ItemsDAO
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.example.clswrk_androidprojekt.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
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
            val itemsExists = itemsDAO.doesItemsEntityExist()
            if (!itemsExists) {
                Log.w("getData", "data not exists")
                val response = apiService.getData()
                Log.w("Data", response.body()?.sampleList.toString())
                response.body()?.sampleList?.let { sample ->
                    sample.map {
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
            itemsEntity.map { item ->
                ItemsModel(item.id, item.description, item.imageUrl, item.isFavorite ?: false)
            }
        }
    }


    override suspend fun deliteItemByDescription(description: String) {
        withContext(Dispatchers.IO) {
            itemsDAO.deliteItemEntityByDescription(description)
        }
    }

    override suspend fun findItemByDescription(searchText: String): ItemsModel {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.findItementityByDescription(searchText)
            ItemsModel(
                itemsEntity.id,
                itemsEntity.description,
                itemsEntity.imageUrl,
                itemsEntity.isFavorite ?: false
            )
        }
    }

    override suspend fun favClicked(itemsModel: ItemsModel, isFavorite: Boolean) {
        return withContext(Dispatchers.IO) {
            itemsDAO.addToFavorite(
                itemsModel.description,
                isFavorite
            )
            itemsDAO.insertFavoritesEntity(
                FavoritesEntity(
                    itemsModel.id,
                    itemsModel.description,
                    itemsModel.image
                )
            )
        }

    }

    override suspend fun getFavorites(): List<FavoriteModel> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDAO.getFavoriteEntities()
            favoritesEntity.map {
                FavoriteModel(it.description, it.imageUrl)
            }
        }
    }
}

