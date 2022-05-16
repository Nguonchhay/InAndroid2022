package com.nguonchhay.inandroid2022.networks.apis

import android.util.Log
import com.nguonchhay.inandroid2022.data_class.NewsKtorResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.HttpHeaders

interface NewsApiInterface {

    suspend fun list(): NewsKtorResponse

    companion object {
        fun getInstance(): NewsApiImpl {
            return NewsApiImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        })
                    }

                    install(Logging) {
                        logger = object : Logger {
                            override fun log(message: String) {
                                Log.v("NewsApiImpl", message)
                            }
                        }
                        level = LogLevel.ALL
                    }

                    install(ResponseObserver) {
                        onResponse { response ->
                            Log.d("HTTP Status", "${response.status.value}")
                        }
                    }

                    install(DefaultRequest) {
                        header(HttpHeaders.ContentType, io.ktor.http.ContentType.Application.Json)
                    }
                }
            )
        }
    }
}