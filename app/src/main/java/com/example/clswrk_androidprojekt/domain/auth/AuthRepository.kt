package com.example.clswrk_androidprojekt.domain.auth

import com.example.clswrk_androidprojekt.model.UserModel

interface AuthRepository {

   suspend fun loginUser(userName:String,userPassword:String)


   suspend fun showUserCreds():UserModel


    suspend fun doesUserExist():Boolean

    suspend fun userLogaut()


}