package com.example.clswrk_androidprojekt.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.ItemsInteractor
import com.example.clswrk_androidprojekt.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor
    (  private val itemsInteractor: ItemsInteractor
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items


    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {
        val listItems = itemsInteractor.getData()

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

