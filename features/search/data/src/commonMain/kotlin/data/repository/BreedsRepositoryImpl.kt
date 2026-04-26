package data.repository

import data.converter.mapToBreeds
import domain.model.Breed
import domain.repository.BreedsRepository
import network.service.ApiService

class BreedsRepositoryImpl(
    private val apiService: ApiService
) : BreedsRepository {

    override suspend fun loadBreeds(): Result<List<Breed>> =
        apiService.loadBreeds().map { breedsDto ->
            breedsDto.mapToBreeds()
        }
}