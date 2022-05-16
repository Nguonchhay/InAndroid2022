package com.nguonchhay.inandroid2022.data_class

import com.google.gson.annotations.SerializedName

data class NewsRetrofit(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("image")
    val image: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("desc")
    val desc: String
)
