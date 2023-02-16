package com.example.clswrk_androidprojekt.data.api

import com.example.clswrk_androidprojekt.data.model.ItemsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/nkuYRM")
    fun getData(): Single<ItemsResponse>


}