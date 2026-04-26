package presentation

import presentation.model.ImageUi

data class DetailsUiState(
    val isLoading: Boolean = false,
    val data: List<ImageUi>? = null,
    val error: String = ""
)