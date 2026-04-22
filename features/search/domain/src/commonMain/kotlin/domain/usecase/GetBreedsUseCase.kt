package domain.usecase

import domain.repository.BreedsRepository

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