package com.nguonchhay.inandroid2022.networks.apis

import android.util.Log
import com.nguonchhay.inandroid2022.data_class.NewsKtor
import com.nguonchhay.inandroid2022.data_class.NewsKtorResponse
import com.nguonchhay.inandroid2022.networks.ApiRoutes
import io.ktor.client.*
import io.ktor.client.request.*
import java.lang.Exception

class NewsApiImpl(val client: HttpClient) : NewsApiInterface {

    override suspend fun list(): NewsKtorResponse {
        return try {
            client.get {
               url(ApiRoutes.BASE_URL + ApiRoutes.API_NEWS_LATEST)
            }
        } catch (e: Exception) {
            Log.v("NewsApiImpl", "Error : ${e.message}")
            NewsKtorResponse(false, emptyList<NewsKtor>())
        }
    }
}