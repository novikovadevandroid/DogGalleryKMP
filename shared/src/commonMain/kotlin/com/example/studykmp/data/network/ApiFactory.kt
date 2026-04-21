package com.example.studykmp.data.network

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient

/**
 * Фабрика по созданию сетевого апи
 *
 * @property BASE_URL базовый url апи
 */
object ApiFactory {

    private const val BASE_URL = "https://dog.ceo/"

    fun createNetworkApi(httpClient: HttpClient): ApiService {
        val ktorfit = Ktorfit.Builder()
            .baseUrl(BASE_URL)
            .httpClient(httpClient)
            .build()

        return ktorfit.createApiService()
    }
}