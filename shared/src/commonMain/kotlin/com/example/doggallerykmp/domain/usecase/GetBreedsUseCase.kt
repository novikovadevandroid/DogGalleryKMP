package com.example.doggallerykmp.domain.usecase

import com.example.doggallerykmp.domain.repository.BreedsRepository

/**
 * Загрузка списка пород из репозитория
 *
 * @property repository Репозиторий
 */
class GetBreedsUseCase(
    private val repository: BreedsRepository
) {

    suspend operator fun invoke() = repository.loadBreeds()
}