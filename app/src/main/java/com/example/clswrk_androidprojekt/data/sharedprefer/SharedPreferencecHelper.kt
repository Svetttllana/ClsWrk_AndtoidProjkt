package com.example.clswrk_androidprojekt.data.sharedprefer

import android.content.SharedPreferences
import com.example.clswrk_androidprojekt.model.UserModel
import javax.inject.Inject

class SharedPreferencecHelper @Inject constructor
    (private val sharedPreferences: SharedPreferences) {


    fun saveUserName(name: String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()

    }

    fun saveUserPassword(password: String?) {

        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()

    }

    fun getUserCreads(): UserModel {
        val name = sharedPreferences.getString(USER_NAME, "") ?: "no user"
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: "no user"
        return UserModel(name, password)
    }

    fun checkUserExists(): Boolean {
        val name = sharedPreferences.getString(USER_NAME, "")
        val password = sharedPreferences.getString(USER_PASSWORD, "")

        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())

    }

    fun removeUser() {
        saveUserName(null)
        saveUserPassword(null)

    }


    companion object {
        private const val USER_PASSWORD = "USER PASSWORD"
        private const val USER_NAME = "USER NAME"

    }

}

