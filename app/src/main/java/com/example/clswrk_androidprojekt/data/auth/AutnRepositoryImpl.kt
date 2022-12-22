package com.example.clswrk_androidprojekt.data.auth

import com.example.clswrk_androidprojekt.data.sharedprefer.SharedPreferencecHelper
import com.example.clswrk_androidprojekt.domain.auth.AuthRepository
import com.example.clswrk_androidprojekt.model.UserModel
import javax.inject.Inject

class AutnRepositoryImpl @Inject constructor(

    private val sharedPreferencecHelper: SharedPreferencecHelper

):AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
sharedPreferencecHelper.saveUserName(userName)
sharedPreferencecHelper.saveUserPassword(userPassword)


    }

    override fun showUserCreds():UserModel {
        return sharedPreferencecHelper.getUserCreads()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencecHelper.checkUserExists()
    }

    override fun userLogaut() {
        sharedPreferencecHelper.removeUser()
    }
}