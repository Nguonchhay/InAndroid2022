package com.nguonchhay.inandroid2022.networks.apis

import android.util.Log
import com.nguonchhay.inandroid2022.data_class.CategoryKtorResponse
import com.nguonchhay.inandroid2022.data_class.CategoryResponse
import com.nguonchhay.inandroid2022.networks.ApiRoutes
import io.ktor.client.*
import io.ktor.client.request.*
import java.lang.Exception

class CategoriesApiImpl(private val client: HttpClient) : CategoriesApiInterface {

    override suspend fun list(): CategoryKtorResponse {
        return try {
            client.get {
                url(ApiRoutes.BASE_URL + ApiRoutes.API_CATEGORIES_HIGHLIGHT)
            }
        } catch (e: Exception) {
            Log.v("CategoriesApiImpl", "Error : ${e.message}")
            CategoryKtorResponse(false, emptyList())
        }
    }
}