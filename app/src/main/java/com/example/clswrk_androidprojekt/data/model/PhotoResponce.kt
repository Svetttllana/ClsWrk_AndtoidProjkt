package com.example.clswrk_androidprojekt.data.model

import javax.inject.Named

data class PhotoResponce(
    val albumId:Int,
    val id:Int,
    val title:String,
    val thumbnailUrl:String
    )

data class PhotoResponceQuery(
    val albumId:Int,
    val id:Int,
    val title:String,
    val thumbnailUrl:String
)