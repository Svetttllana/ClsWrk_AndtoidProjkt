package com.example.clswrk_androidprojekt.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.clswrk_androidprojekt.data.api.ApiService
import com.example.clswrk_androidprojekt.data.api.ApiServiceSecond
import com.example.clswrk_androidprojekt.data.auth.AutnRepositoryImpl
import com.example.clswrk_androidprojekt.data.items.ItemsRepositoryImpl
import com.example.clswrk_androidprojekt.data.sharedprefer.SharedPreferencecHelper
import com.example.clswrk_androidprojekt.domain.auth.AuthRepository
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module



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

        private const val BASE_URL = "https://api.jsonserve.com"
        private const val BASE_URL_SECOND = " https://jsonplaceholder.typicode.com"
        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(
            context: Context
        ): SharedPreferencecHelper {

            return SharedPreferencecHelper(
                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)
            )

        }

        @Named("FIRST")
        @Provides
        fun provideApiService(@Named("FIRST")retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }


        @Named("FIRST")
        @Provides
        fun provideRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        @Named("SECOND")
        @Provides
        fun provideApiServiceSecond(@Named("SECOND")retrofit: Retrofit): ApiServiceSecond {
            return retrofit.create(ApiServiceSecond::class.java)
        }

        @Named("SECOND")
        @Provides
        fun provideRetrofitInstanceSecond(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BASE_URL_SECOND)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }








    }




}