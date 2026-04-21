package com.example.studykmp.data.network

import com.example.studykmp.data.network.dto.BreedsDto
import de.jensklingenberg.ktorfit.http.GET

/**
 * Функционал сетевого апи
 */
interface ApiService {
    /**
     * Получить все породы
     *
     * @return Мапа пород
     */
    @GET("api/breeds/list/all")
    suspend fun getBreeds(): BreedsDto
}