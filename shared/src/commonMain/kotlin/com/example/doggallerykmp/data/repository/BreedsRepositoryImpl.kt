package com.example.doggallerykmp.data.repository

import com.example.doggallerykmp.data.converter.toBreeds
import com.example.doggallerykmp.data.network.ApiService
import com.example.doggallerykmp.domain.repository.BreedsRepository
import com.example.doggallerykmp.models.domain.Breed

/**
 * Имплементация бизнес логики приложения
 */
class BreedsRepositoryImpl(
    private val apiService: ApiService
) : BreedsRepository {

    /**
     * Загрузить список пород и преобразовать в модели бизнес логики
     *
     * @return Список моделей пород
     */
    override suspend fun loadBreeds(): List<Breed> = apiService.getDtoBreeds().toBreeds()
}