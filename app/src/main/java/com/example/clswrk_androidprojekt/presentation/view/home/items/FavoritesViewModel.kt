package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.domain.items.ItemsInteractor
import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class FavoritesViewModel @Inject constructor(
private val itemsInteractor: ItemsInteractor
):ViewModel() {

    private val _favorite = MutableLiveData<List<FavoriteModel>>()
    val favorite  = _favorite

    fun getFavorites(){
        viewModelScope.launch {
            try {
              val favoritesItems = itemsInteractor.getFavorites()
              _favorite.value= favoritesItems
            }catch (e:Exception){
                Log.w("Fav Error", e.toString())

            }
        }

    }



}