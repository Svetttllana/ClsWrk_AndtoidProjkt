package com.example.clswrk_androidprojekt.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ItemsEntity")
data class ItemsEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo( "id")
    val id:Int,
    @ColumnInfo( "description")
    val description:String,
    @ColumnInfo( "imageUrl4")
    val imageUrl:String,
    @ColumnInfo("isFavorite")
    val isFavorite:Boolean?=false //используем вопросик и значение по умолчанию

)
