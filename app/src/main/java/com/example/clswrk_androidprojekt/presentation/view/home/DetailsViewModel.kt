package com.example.clswrk_androidprojekt.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav


    fun logautUser() {
        authInteractor.logautUser()
        _nav.value = Unit

    }

}