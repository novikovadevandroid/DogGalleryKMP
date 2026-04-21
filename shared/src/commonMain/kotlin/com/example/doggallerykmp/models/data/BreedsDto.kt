package com.example.doggallerykmp.models.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Сетевая модель со списком пород
 *
 * @property name Мапа с названиями пород
 * @property status Статус операции
 */
@Serializable
data class BreedsDto(
    @SerialName("message")
    val name: Map<String, List<String>>,
    @SerialName("status")
    val status: String
)