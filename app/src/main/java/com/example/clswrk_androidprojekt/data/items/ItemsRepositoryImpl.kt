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
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import kotlinx.coroutines.Dispatchers
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

    private val compositeDisposable = CompositeDisposable()
    override fun getData(): Completable {
        return itemsDAO.doesItemsEntityExist()
            .subscribeOn(Schedulers.io())
            .doAfterNext {
                if (!it) {
                    val response = apiService.getData()
                 val getData=   response.subscribeOn(Schedulers.io())
                        .doAfterSuccess {
                                it.sampleList.map {
                                    val itemsEntity =
                                        ItemsEntity(Random().nextInt(), it.description, it.imageUrl)
                                    itemsDAO.insertItemsEntity(itemsEntity)
                                }

                        }.doOnError {
                            Log.w("error", "when making request")
                        }
                        .ignoreElement()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                         compositeDisposable.add(getData)
                }
            }.ignoreElements()
            .observeOn(AndroidSchedulers.mainThread())
    }


    override fun showData(): io.reactivex.Observable<List<ItemsModel>> {

        val itemsEntity = itemsDAO.getItemsEntities()

        return itemsEntity.subscribeOn(Schedulers.io())
            .map {
                it.map { item ->
                    ItemsModel(item.id, item.description, item.imageUrl, item.isFavorite ?: false)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
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


