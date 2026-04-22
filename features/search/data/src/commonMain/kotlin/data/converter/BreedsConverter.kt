package data.converter

import domain.model.Breed
import network.models.BreedsDto

/**
 * Конвертация пород из сетевой модели в бизнес модель
 */
fun BreedsDto.mapToBreeds() = this.names.keys.map { breed ->
    Breed(name = breed)
}