package com.nguonchhay.inandroid2022.data_class

import kotlinx.serialization.Serializable

@Serializable
data class NewsKtor(
    val id: Int? = null,
    val image: String,
    val title: String,
    val desc: String
)
