package com.example.clswrk_androidprojekt.data.api

import com.example.clswrk_androidprojekt.data.model.PhotoResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceSecond {

    @GET("/photos/{id}")
    suspend fun getPhotosById(@Path("id") photoId:Int):Response<PhotoResponce>

    @GET("/photo")
    suspend fun getPhotoByTitle(@Query("title")title:String) :Response<List<PhotoResponce>>

}