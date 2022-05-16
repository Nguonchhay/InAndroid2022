package com.nguonchhay.inandroid2022.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiRoutes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}