package com.example.clswrk_androidprojekt.data.auth

import com.example.clswrk_androidprojekt.data.sharedprefer.SharedPreferencecHelper
import com.example.clswrk_androidprojekt.domain.auth.AuthRepository
import com.example.clswrk_androidprojekt.domain.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AutnRepositoryImpl @Inject constructor(

    private val sharedPreferencecHelper: SharedPreferencecHelper

) : AuthRepository {
    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencecHelper.saveUserName(userName)
            sharedPreferencecHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO) {
            sharedPreferencecHelper.getUserCreads()
        }
    }

    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO) {
              sharedPreferencecHelper.checkUserExists()
        }
    }

    override suspend fun userLogaut() {
        withContext(Dispatchers.IO) {
            sharedPreferencecHelper.removeUser()
        }
    }
}