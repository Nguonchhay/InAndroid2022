package com.nguonchhay.inandroid2022.data_class

import kotlinx.serialization.Serializable

@Serializable
data class NewsKtorResponse(
    val success: Boolean,
    val data: List<NewsKtor>
)
