package com.example.clswrk_androidprojekt.data.model

import com.google.gson.annotations.SerializedName

data class ItemsResponse(

    @SerializedName("sample")
    val sampleList:List<Sample>
)

data class Sample(

    @SerializedName("description")
    val description:String,
    @SerializedName("image-url")
    val imageUrl:String

)
