package presentation

import presentation.model.BreedUi

data class SearchUiState(
    val isLoading: Boolean = false,
    val data: List<BreedUi>? = null,
    val error: String = ""
)