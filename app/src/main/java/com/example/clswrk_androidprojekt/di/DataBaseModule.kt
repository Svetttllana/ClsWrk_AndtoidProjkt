package com.example.clswrk_androidprojekt.di

import android.content.Context
import com.example.clswrk_androidprojekt.data.database.dao.ItemsDAO
import com.example.clswrk_androidprojekt.data.database.dao.ItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

class DataBaseModule {

    @Provides
    fun provideItemsDAO(itemsDatabase: ItemsDatabase): ItemsDAO {
        return itemsDatabase.getItemsDAO()
    }


    @Provides
    fun provideItemsDatabase(context: Context): ItemsDatabase {
        return ItemsDatabase.getItemsDatabaseInstance(context)

    }

}