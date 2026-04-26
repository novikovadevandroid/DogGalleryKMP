package domain.usecase

import domain.repository.ImageRepository

class GetImagesUseCase(
    private val repository: ImageRepository
) {

    suspend operator fun invoke(breed: String, count: Int) = repository.loadImages(breed, count)
}