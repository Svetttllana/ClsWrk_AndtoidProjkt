package com.example.clswrk_androidprojekt.data

import com.example.clswrk_androidprojekt.data.model.ItemsResponse
import okhttp3.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/nkuYRM")
    suspend fun getData():Response<ItemsResponse>


}