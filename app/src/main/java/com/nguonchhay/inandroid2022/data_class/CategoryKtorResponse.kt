package com.nguonchhay.inandroid2022.data_class

import kotlinx.serialization.Serializable

@Serializable
data class CategoryKtorResponse(
    val success: Boolean,
    val data: List<CategoryResponse>
)

@Serializable
data class CategoryResponse(
    val id: Int? = null,
    val image: String
)