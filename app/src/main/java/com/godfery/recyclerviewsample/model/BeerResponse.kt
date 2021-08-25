package com.godfery.recyclerviewsample.model

import com.google.gson.annotations.SerializedName

data class BeerResponse(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name : String = "",

    @SerializedName("tagline")
    val tagline : String = "",

    @SerializedName("image_url")
    val image_url : String = ""
)
