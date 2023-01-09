package com.example.clswrk_androidprojekt.domain.auth

import com.example.clswrk_androidprojekt.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {


  suspend  fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    suspend fun getUserCreads(): UserModel {

       return authRepository.showUserCreds()

    }

    suspend  fun checkUserExists():Boolean {
        return authRepository.doesUserExist()
    }

    suspend fun logautUser(){
       authRepository.userLogaut()
   }

}