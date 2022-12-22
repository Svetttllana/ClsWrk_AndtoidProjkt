package com.example.clswrk_androidprojekt.di

import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import com.example.clswrk_androidprojekt.domain.items.ItemsInteractor
import com.example.clswrk_androidprojekt.presentation.auth.LoginPresenter
import com.example.clswrk_androidprojekt.presentation.auth.OnBoardingPresenter
import com.example.clswrk_androidprojekt.presentation.view.MainPresenter
import com.example.clswrk_androidprojekt.presentation.view.home.DetailsPresenter
import com.example.clswrk_androidprojekt.presentation.view.home.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class PresentationModule {

    @Provides
    fun providePresenter(authInteractor: AuthInteractor):MainPresenter{
        return MainPresenter(authInteractor)
    }


    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor):LoginPresenter{
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideOnBoardingPresenter():OnBoardingPresenter{
        return OnBoardingPresenter()
    }

    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }


    @Provides
    fun provideDetailsPresenter(authInteractor: AuthInteractor): DetailsPresenter {
        return DetailsPresenter(authInteractor)
    }
}