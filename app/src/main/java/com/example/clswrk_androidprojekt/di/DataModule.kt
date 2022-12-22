package com.example.clswrk_androidprojekt.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.clswrk_androidprojekt.data.sharedprefer.SharedPreferencecHelper
import com.example.clswrk_androidprojekt.data.auth.AutnRepositoryImpl
import com.example.clswrk_androidprojekt.data.items.ItemsRepositoryImpl
import com.example.clswrk_androidprojekt.domain.auth.AuthRepository
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)


abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository


    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AutnRepositoryImpl
    ): AuthRepository


    companion object {


        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context: Context
        ): SharedPreferencecHelper {

            return SharedPreferencecHelper(
                context.getSharedPreferences(SP_KEY,MODE_PRIVATE )
            )


        }
    }

}