package com.example.clswrk_androidprojekt.presentation.dataBinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){


    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()

    val userCreads = MutableLiveData<String>()


    fun showCreads() {

        userCreads.value = "${userName.value.toString()}\n${userPassword.value.toString()}"

    }

}