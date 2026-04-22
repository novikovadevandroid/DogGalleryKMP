package network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Сетевая модель со списком пород
 *
 * @property names Мапа с названиями пород
 * @property status Статус операции
 */
@Serializable
data class BreedsDto(
    @SerialName("message")
    val names: Map<String, List<String>>,
    @SerialName("status")
    val status: String
)