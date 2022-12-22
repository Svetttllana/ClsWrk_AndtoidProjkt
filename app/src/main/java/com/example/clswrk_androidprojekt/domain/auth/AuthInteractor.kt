package com.example.clswrk_androidprojekt.domain.auth

import com.example.clswrk_androidprojekt.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {


    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreads(): UserModel {

        return authRepository.showUserCreds()

    }

    fun checkUserExists():Boolean {
        return authRepository.doesUserExist()
    }

   fun logautUser(){
       authRepository.userLogaut()
   }

}