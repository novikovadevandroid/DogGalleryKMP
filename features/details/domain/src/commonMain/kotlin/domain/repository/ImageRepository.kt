package domain.repository

import domain.models.BreedImage

interface ImageRepository {

    suspend fun loadImages(breed: String, count: Int): Result<List<BreedImage>>
}