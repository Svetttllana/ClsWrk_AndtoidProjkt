package com.example.clswrk_androidprojekt.presentation.view.home

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.domain.items.ItemsInteractor
import com.example.clswrk_androidprojekt.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SeaechViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor

):ViewModel(){


    private val _item =MutableLiveData<ItemsModel>()
    val item : LiveData<ItemsModel> = _item



    fun findItem(searchText:String){
        viewModelScope.launch {
            try {
            _item.value= itemsInteractor.findItem(searchText)
            }catch (e: Exception){
                Log.w("exception", "not item search")
            }

        }

    }

}