package com.example.doggallerykmp.data.network

import com.example.doggallerykmp.models.data.BreedsDto
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
    suspend fun getDtoBreeds(): BreedsDto
}