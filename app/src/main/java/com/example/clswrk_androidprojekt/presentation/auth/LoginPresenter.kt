package com.example.clswrk_androidprojekt.presentation.auth

import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment){
        loginView=loginFragment
    }


fun loginUser(userName:String,userPassword:String){
    authInteractor.loginUser(userName,userPassword)
    loginView.userLoggedIn()

}

}