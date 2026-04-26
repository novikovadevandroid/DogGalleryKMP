package network.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {

    fun getInstance(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true

                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 5_000
                socketTimeoutMillis = 5_000
                connectTimeoutMillis = 5_000
            }
            install(DefaultRequest) {
                url {
                    host = "dog.ceo"
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }
}