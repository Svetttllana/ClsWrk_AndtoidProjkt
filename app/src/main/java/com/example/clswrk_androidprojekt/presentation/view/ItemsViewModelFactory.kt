package com.example.clswrk_androidprojekt.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clswrk_androidprojekt.domain.ItemsInteractor

class ItemsViewModelFactory(
    private val itemsInteractor: ItemsInteractor,

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }


}