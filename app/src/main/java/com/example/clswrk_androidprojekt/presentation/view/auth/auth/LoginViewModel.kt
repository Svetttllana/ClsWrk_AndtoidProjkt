package com.example.clswrk_androidprojekt.presentation.view.auth.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor

) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav


    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_,exeption ->
            Log.w("ExeptionHandler called", exeption.toString())
        }

        viewModelScope.launch(CoroutineName("with exeption")+coroutineExceptionHandler) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _nav.value = R.id.action_loginFragment_to_homeFragment
                }

            } catch (e: Exception) {
                Log.w("exeption", "loginUser FAILED")
            }


        }
    }

    fun userNavigated(){
        _nav.value = null
    }


}