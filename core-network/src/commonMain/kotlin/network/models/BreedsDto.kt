package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedsDto(
    @SerialName("message")
    val names: Map<String, List<String>>,
    @SerialName("status")
    val status: String
)