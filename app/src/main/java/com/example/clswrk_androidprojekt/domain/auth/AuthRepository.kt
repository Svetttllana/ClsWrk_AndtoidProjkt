package com.example.clswrk_androidprojekt.domain.auth

import com.example.clswrk_androidprojekt.model.UserModel

interface AuthRepository {

    fun loginUser(userName:String,userPassword:String)


    fun showUserCreds():UserModel


    fun doesUserExist():Boolean

    fun userLogaut()


}