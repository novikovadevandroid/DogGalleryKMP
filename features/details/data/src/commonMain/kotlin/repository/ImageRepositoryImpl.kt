package repository

import data.mapToImages
import domain.models.BreedImage
import domain.repository.ImageRepository
import network.service.ApiService

class ImageRepositoryImpl(
    private val apiService: ApiService
) : ImageRepository {

    override suspend fun loadImages(breed: String, count: Int): Result<List<BreedImage>> =
        apiService.loadImagesByBreed(breed, count).map { imagesDto ->
            imagesDto.mapToImages()
        }
}