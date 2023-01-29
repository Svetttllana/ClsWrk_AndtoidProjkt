package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.items.ItemsInteractor
import com.example.clswrk_androidprojekt.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {
        viewModelScope.launch {
            try {
                itemsInteractor.getData()
                _items.value = itemsInteractor.showData()
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }


    fun imageViewClicked() {

        _msg.value = R.string.image_view_clicked
    }

    fun elementClicked(description: String, image: String) {

        _bundle.value = NavigateWithBundle(
            description = description,
            image = image,
            destinationiD = R.id.action_itemsFragment_to_detailsFragment
        )
    }


    fun userNavigated() {
        _bundle.value = null
    }

    fun deliteItem(description: String) {
        viewModelScope.launch {
            try {
                itemsInteractor.deliteItemByDescription(description)
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }

    fun onFavClicked(description: String) {
        viewModelScope.launch {
          //  try {
                itemsInteractor.onFavClicked(description)
//            }catch (e:Exception){
//
//            }

        }
    }


}

data class NavigateWithBundle(
    val image: String,
    val description: String,
    val destinationiD: Int

)
