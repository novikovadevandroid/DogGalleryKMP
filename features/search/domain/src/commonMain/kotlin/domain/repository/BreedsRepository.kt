package domain.repository

import domain.model.Breed

/**
 * Бизнес логика фичи
 */
interface BreedsRepository {
    /**
     * Загрузить список пород
     *
     * @return Список моделей пород
     */
    suspend fun loadBreeds(): List<Breed>

}