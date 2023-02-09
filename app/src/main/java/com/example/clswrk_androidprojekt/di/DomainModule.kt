package com.example.clswrk_androidprojekt.di

import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import com.example.clswrk_androidprojekt.domain.auth.AuthRepository
import com.example.clswrk_androidprojekt.domain.items.ItemsInteractor
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides

@Module



class DomainModule {

    @Provides
    fun provideItemsInteractor(
        itemsRepository: ItemsRepository
    ): ItemsInteractor {

        return  ItemsInteractor(itemsRepository)
    }



@Provides
    fun provideAuthInteractor(
        authRepository: AuthRepository
    ): AuthInteractor {

        return  AuthInteractor(authRepository)
    }
}