package com.example.clswrk_androidprojekt.presentation.auth

import javax.inject.Inject

class OnBoardingPresenter @Inject constructor() {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment){
        onBoardingView=onBoardingFragment

    }

    fun goToItemsFragment(){
        onBoardingView.goToItemsFragment()

    }

}