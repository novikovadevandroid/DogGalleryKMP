package com.example.doggallerykmp.domain.repository

import com.example.doggallerykmp.models.domain.Breed

/**
 * Бизнес логика приложения
 */
interface BreedsRepository {

    /**
     * Загрузить список пород
     *
     * @return Список моделей пород
     */
    suspend fun loadBreeds(): List<Breed>
}