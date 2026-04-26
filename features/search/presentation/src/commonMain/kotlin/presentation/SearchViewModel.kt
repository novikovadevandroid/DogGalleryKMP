package presentation

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import domain.usecase.GetBreedsUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import presentation.converter.mapToUiBreeds

class SearchViewModel(
    private val useCase: GetBreedsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        viewModelScope = viewModelScope,
        value = SearchUiState()
    )

    @NativeCoroutinesState
    val uiState: StateFlow<SearchUiState> = _uiState

    init {
        loadBreeds()
    }

    private fun loadBreeds() {
        viewModelScope.launch {
            _uiState.collectLatest {
                _uiState.update { SearchUiState(isLoading = true) }
                useCase.invoke().onSuccess { data ->
                    _uiState.update { SearchUiState(data = data.mapToUiBreeds()) }
                }.onFailure { error ->
                    _uiState.update { SearchUiState(error = error.message.toString()) }
                }
            }
        }
    }
}