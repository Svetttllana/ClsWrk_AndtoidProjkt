package com.example.clswrk_androidprojekt.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.data.database.ItemsEntity


@Database(entities = [ItemsEntity::class, FavoritesEntity::class], version = 4, exportSchema = false)
abstract class ItemsDatabase:RoomDatabase() {

 abstract fun getItemsDAO():ItemsDAO

     companion object{

        private const val DATABASE_NAME = "DATABASE_NAME"
        private var DB_INSTANCE:ItemsDatabase? = null

        fun getItemsDatabaseInstance(context: Context):ItemsDatabase{

            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    DATABASE_NAME
                )
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_3_TO_4)
                .build()
                .also { DB_INSTANCE = it }

        }

         private val MIGRATION_3_TO_4 = object : Migration(3,4){
             override fun migrate(database: SupportSQLiteDatabase) {
                 database.execSQL("ALTER TABLE ItemsEntity RENAME COLUMN imageUrl3 TO imageUrl4")
             }
         }

    }

}