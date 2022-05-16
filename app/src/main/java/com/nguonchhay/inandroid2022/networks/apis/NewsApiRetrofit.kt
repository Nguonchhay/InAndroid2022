package com.nguonchhay.inandroid2022.networks.apis

import com.nguonchhay.inandroid2022.data_class.NewsRetrofit
import com.nguonchhay.inandroid2022.networks.ApiRoutes
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NewsApiRetrofit {

    @GET(ApiRoutes.API_NEWS_LIST)
    @Headers("Content-Type: application/json")
    suspend fun list(): List<NewsRetrofit>

    @POST(ApiRoutes.API_NEWS_LIST)
    @Headers("Content-Type: application/json")
    suspend fun store(@Body news: NewsRetrofit): NewsRetrofit
}