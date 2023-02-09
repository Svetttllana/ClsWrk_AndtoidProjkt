package com.example.clswrk_androidprojekt.utils

import android.app.Application
import com.example.clswrk_androidprojekt.di.AppModule
import com.example.clswrk_androidprojekt.di.component.AppComponent
import com.example.clswrk_androidprojekt.di.component.DaggerAppComponent


class App:Application() {

    lateinit var appComponent: AppComponent

    fun provideAppComponent():AppComponent{
appComponent= DaggerAppComponent
    .builder()
    .appModule(AppModule(this))
    .build()
        return appComponent
    }


}






