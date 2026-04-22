package data.repository

import data.converter.mapToBreeds
import domain.model.Breed
import domain.repository.BreedsRepository
import network.service.ApiService

/**
 * Имплементация бизнес логики фичи
 */
class BreedsRepositoryImpl(
    private val apiService: ApiService
) : BreedsRepository {
    /**
     * Загрузить список пород и преобразовать в модели бизнес логики
     *
     * @return Список пород или пустой список
     */
    override suspend fun loadBreeds(): List<Breed> =
        apiService.loadBreeds().getOrNull()?.mapToBreeds().orEmpty()
}