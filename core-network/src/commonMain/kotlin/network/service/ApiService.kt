package network.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.models.BreedsDto
import network.models.ImagesDto

class ApiService(
    private val httpClient: HttpClient
) {
    suspend fun loadBreeds(): Result<BreedsDto> =
        try {
            val breedsResponse = httpClient.get(BREEDS_ENDPOINT).body<BreedsDto>()
            Result.success(breedsResponse)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }

    suspend fun loadImagesByBreed(breed: String, count: Int): Result<ImagesDto> =
        try {
            val imagesResponse = httpClient.get(buildImagesEndpoint(breed, count)).body<ImagesDto>()
            Result.success(imagesResponse)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }

    private fun buildImagesEndpoint(breed: String, count: Int): String =
        "api/breed/$breed/images/random/$count"

    companion object {
        private const val BREEDS_ENDPOINT = "api/breeds/list/all"
    }
}