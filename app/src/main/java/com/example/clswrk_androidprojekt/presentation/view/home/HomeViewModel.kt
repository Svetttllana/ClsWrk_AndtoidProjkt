package com.example.clswrk_androidprojekt.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import com.example.clswrk_androidprojekt.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor

):ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds:LiveData<UserModel> = _userCreds

    fun showUserData(){
        viewModelScope.launch {

            //_userCreds.value = UserModel(R.navigation.main_graph)
            _userCreds.value = authInteractor.getUserCreads()
        }

    }


}