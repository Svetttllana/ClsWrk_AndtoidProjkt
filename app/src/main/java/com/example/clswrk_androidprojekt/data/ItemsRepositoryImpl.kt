package com.example.clswrk_androidprojekt.data

import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.ItemsRepository
import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsRepositoryImpl:ItemsRepository {
    override fun getData():List<ItemsModel> {
        val listItems = listOf<ItemsModel>(

            ItemsModel(R.drawable.banana, "Android", "20.20.2020"),
            ItemsModel(R.drawable.apple, " IOS,", "10.10.2020"),
            ItemsModel(R.drawable.rofl_kit3, "Flutter", "19.20.2022"),
            ItemsModel(R.drawable.rofl, "Python", "20.10.2023"),
            ItemsModel(R.drawable.apple, "Xamarin", "02.04.2024"),
            ItemsModel(R.drawable.banana, ".NET", "20.20.2020"),
            ItemsModel(R.drawable.rose_image, "C++", "06.05.2020"),
            ItemsModel(R.drawable.rofl_kit3, "C", "07.10.2020"),
            ItemsModel(R.drawable.rofl_kit2, "PHP", "20.06.2020"),
            ItemsModel(R.drawable.chmonya_image, "Ruby on Rails", "20.06.2020"),
            ItemsModel(R.drawable.rofl, "JS", "20.06.2020"),
            ItemsModel(R.drawable.mem_kit_ofise, "apple", "20.06.2020"),
            ItemsModel(R.drawable.mem_kit_image, "pineaple", "20.06.2020")

        )
        return listItems
    }
}