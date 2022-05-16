package com.nguonchhay.inandroid2022.networks.apis

import android.util.Log
import com.nguonchhay.inandroid2022.data_class.NewsKtor
import com.nguonchhay.inandroid2022.data_class.NewsKtorResponse
import com.nguonchhay.inandroid2022.networks.ApiRoutes
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.Exception

class NewsApiImpl(val client: HttpClient) : NewsApiInterface {

    override suspend fun list(): NewsKtorResponse {
        return try {
            client.get {
               url(ApiRoutes.BASE_URL + ApiRoutes.API_NEWS_LATEST)
            }
        } catch (e: Exception) {
            Log.v("NewsApiImpl_GET", "Error : ${e.message}")
            NewsKtorResponse(false, emptyList<NewsKtor>())
        }
    }

    override suspend fun store(news: NewsKtor): NewsKtor {
        return try {
            client.post {
                url(ApiRoutes.BASE_URL + ApiRoutes.API_NEWS_STORE)
                contentType(ContentType.Application.Json)
                body = news
            }
        } catch (e: RedirectResponseException) {
            Log.v("NewsApiImpl_POST", "Error 3.x.x : ${e.response.status.description}")
            NewsKtor(0, "", "", "")
        } catch (e: ClientRequestException) {
            Log.v("NewsApiImpl_POST", "Error 4.x.x : ${e.response.status.description}")
            NewsKtor(0, "", "", "")
        } catch (e: ServerResponseException) {
            Log.v("NewsApiImpl_POST", "Error 5.x.x: ${e.response.status.description}")
            NewsKtor(0, "", "", "")
        } catch (e: Exception) {
            Log.v("NewsApiImpl_POST", "Error : ${e.message}")
            NewsKtor(0, "", "", "")
        }
    }
}