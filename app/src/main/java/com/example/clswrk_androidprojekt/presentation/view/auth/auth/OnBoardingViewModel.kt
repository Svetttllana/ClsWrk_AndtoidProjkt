package com.example.clswrk_androidprojekt.presentation.view.auth.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor()
    : ViewModel() {

    private val _nav = MutableLiveData<navToItems?>()
    val nav: LiveData<navToItems?> = _nav

    val onBoardingText = MutableLiveData<String>("default value")

    fun finishButtonClicked() {
        _nav.value = navToItems(R.id.action_onBoardingFragment_to_itemsFragment,R.id.onBoardingFragment)

    }

    fun finishPerformed() {
        _nav.value = null
    }

}


data class navToItems(
    val destinationId:Int,
    val removeFragmentId:Int

)