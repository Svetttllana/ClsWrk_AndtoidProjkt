package com.example.clswrk_androidprojekt

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items


    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {

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
        _items.value = listItems

    }

    fun imageViewClicked() {

        _msg.value = R.string.image_view_clicked
    }

    fun elementClicked(name: String, date: String, imageView: Int) {

        _bundle.value = NavigateWithBundle(name = name, date = date, image = imageView)
    }


    fun userNavigated(){
        _bundle.value= null
    }


}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String

)