package data

import domain.models.BreedImage
import network.models.ImagesDto

fun ImagesDto.mapToImages() = this.urls.map { url ->
    BreedImage(url = url)
}