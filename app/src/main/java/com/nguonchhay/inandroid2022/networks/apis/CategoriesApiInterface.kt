package com.nguonchhay.inandroid2022.networks.apis

import com.nguonchhay.inandroid2022.data_class.CategoryKtorResponse
import com.nguonchhay.inandroid2022.networks.KtorClient

interface CategoriesApiInterface {

    suspend fun list(): CategoryKtorResponse

    companion object {
        fun getInstance(): CategoriesApiImpl = CategoriesApiImpl(client = KtorClient.getClient())
    }
}