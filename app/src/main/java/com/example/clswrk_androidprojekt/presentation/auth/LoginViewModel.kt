package com.example.clswrk_androidprojekt.presentation.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
// во фрагменте мы ничего в поток не ставим!!!!!!!!!!!!
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor

) : ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_,exeption ->
            Log.w("ExeptionHandler called", exeption.toString())
        }

        viewModelScope.launch(CoroutineName("with exeption")+coroutineExceptionHandler) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _nav.value = Unit
                }

            } catch (e: Exception) {
                Log.w("exeption", "loginUser FAILED")
            }


        }
    }


}