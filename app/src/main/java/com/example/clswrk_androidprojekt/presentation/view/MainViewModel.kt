package com.example.clswrk_androidprojekt.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _userExists = MutableLiveData<Boolean>()
    val userExists : LiveData<Boolean> = _userExists

    fun checkUserExists(){
        viewModelScope.launch {
            _userExists.value = authInteractor.checkUserExists()
        }

    }

}