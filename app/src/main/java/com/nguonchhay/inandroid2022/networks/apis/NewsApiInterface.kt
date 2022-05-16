package com.nguonchhay.inandroid2022.networks.apis

import com.nguonchhay.inandroid2022.data_class.NewsKtorResponse
import com.nguonchhay.inandroid2022.networks.KtorClient

interface NewsApiInterface {

    suspend fun list(): NewsKtorResponse

    companion object {
        fun getInstance(): NewsApiImpl {
            return NewsApiImpl(
                client = KtorClient.getClient()
            )
        }
    }
}