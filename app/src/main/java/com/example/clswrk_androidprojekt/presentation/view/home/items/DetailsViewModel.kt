package com.example.clswrk_androidprojekt.presentation.view.home.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav


    fun logautUser() {
        viewModelScope.launch {
            authInteractor.logautUser()
            _nav.value = R.navigation.auth_graph

        }
    }

}