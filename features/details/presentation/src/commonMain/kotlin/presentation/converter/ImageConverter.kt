package presentation.converter

import domain.models.BreedImage
import presentation.model.ImageUi

fun List<BreedImage>.mapToImageUi() = this.map { breedImage ->
    ImageUi(url = breedImage.url)
}