package presentation.converter

import domain.model.Breed
import presentation.model.BreedUi

fun List<Breed>.mapToUiBreeds() = this.map { breed ->
    BreedUi(name = breed.name)
}