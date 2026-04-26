package presentation

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import domain.usecase.GetImagesUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import presentation.converter.mapToImageUi

class DetailsViewModel(
    private val useCase: GetImagesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        viewModelScope = viewModelScope,
        value = DetailsUiState()
    )

    @NativeCoroutinesState
    val uiState: StateFlow<DetailsUiState> = _uiState

    fun loadImages(breed: String, count: Int) {
        viewModelScope.launch {
            _uiState.collect {
                _uiState.update { DetailsUiState(isLoading = true) }
                useCase.invoke(breed, count).onSuccess { data ->
                    _uiState.update { DetailsUiState(data = data.mapToImageUi()) }
                }.onFailure { error ->
                    _uiState.update { DetailsUiState(error = error.message.toString()) }
                }
            }
        }
    }
}