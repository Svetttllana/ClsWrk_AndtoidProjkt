package com.example.clswrk_androidprojekt.data.items

import android.util.Log
import androidx.lifecycle.Transformations.map
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.data.ApiService
import com.example.clswrk_androidprojekt.data.ApiServiceSecond
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class ItemsRepositoryImpl @Inject constructor(
    @Named("FIRST") private val apiService: ApiService,
    @Named("SECOND") private val apiServiceSecond: ApiServiceSecond
) : ItemsRepository {
    override suspend fun getData(): List<ItemsModel> {

        return withContext(Dispatchers.IO) {

            val responseSecond = apiServiceSecond.getPhotosById(3)
            Log.w("SECOND RESPONCE", responseSecond.body()?.title.toString())

            val responseSecondQuery = apiServiceSecond.getPhotoByTitle("reprehenderit est deserunt velit ipsam")
            Log.w("SECOND RESPONCE QUERY", responseSecondQuery.body()?.get(0).toString())

            val response = apiService.getData()
            response.body()?.sampleList?.let {
                it.map {
                    ItemsModel(it.description, it.imageUrl)
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
        //(

//            ItemsModel(R.drawable.banana, "Android", "20.20.2020"),
//            ItemsModel(R.drawable.apple, " IOS,", "10.10.2020"),
//            ItemsModel(R.drawable.rofl_kit3, "Flutter", "19.20.2022"),
//            ItemsModel(R.drawable.rofl, "Python", "20.10.2023"),
//            ItemsModel(R.drawable.apple, "Xamarin", "02.04.2024"),
//            ItemsModel(R.drawable.banana, ".NET", "20.20.2020"),
//            ItemsModel(R.drawable.rose_image, "C++", "06.05.2020"),
//            ItemsModel(R.drawable.rofl_kit3, "C", "07.10.2020"),
//            ItemsModel(R.drawable.rofl_kit2, "PHP", "20.06.2020"),
//            ItemsModel(R.drawable.chmonya_image, "Ruby on Rails", "20.06.2020"),
//            ItemsModel(R.drawable.rofl, "JS", "20.06.2020"),
//            ItemsModel(R.drawable.mem_kit_ofise, "apple", "20.06.2020"),
//            ItemsModel(R.drawable.mem_kit_image, "pineaple", "20.06.2020")
//
//        )
        //       return listItems
    }
}

