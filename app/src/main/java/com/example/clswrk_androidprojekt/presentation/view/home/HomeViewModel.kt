package com.example.clswrk_androidprojekt.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import com.example.clswrk_androidprojekt.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor

):ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds:LiveData<UserModel> = _userCreds

    fun showUserData(){
        _userCreds.value = authInteractor.getUserCreads()
    }

}