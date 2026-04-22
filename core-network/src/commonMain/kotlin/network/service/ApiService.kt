package network.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.models.BreedsDto

/**
 * Функционал сетевого апи
 *
 * @property httpClient Http клиент для запросов
 */
class ApiService(
    private val httpClient: HttpClient
) {

    /**
     * Получить все породы
     *
     * @return Результат запроса
     */
    suspend fun loadBreeds(): Result<BreedsDto> =
        try {
            val breedsResponse = httpClient.get(BREEDS_ENDPOINT).body<BreedsDto>()
            Result.success(breedsResponse)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }

    companion object {
        private const val BREEDS_ENDPOINT = "api/breeds/list/all"
    }
}