package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesDto(
    @SerialName("message")
    val urls: List<String>,
    @SerialName("status")
    val status: String
)
