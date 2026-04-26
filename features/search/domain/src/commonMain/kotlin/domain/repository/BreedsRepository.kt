package domain.repository

import domain.model.Breed

interface BreedsRepository {
    suspend fun loadBreeds(): Result<List<Breed>>
}