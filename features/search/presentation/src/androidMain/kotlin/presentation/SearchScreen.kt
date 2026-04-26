package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import presentation.model.BreedUi

@Composable
fun SearchScreen() {
    val viewModel = koinViewModel<SearchViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when {
        uiState.isLoading -> {
            SearchLoading()
        }

        uiState.data != null -> {
            uiState.data?.let { data ->
                SearchScreenContent(data = data)
            }
        }

        uiState.error.isNotEmpty() -> {
            SearchError(error = uiState.error)
        }
    }
}

@Composable
private fun SearchScreenContent(
    data: List<BreedUi>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(items = data) { breed ->
            SearchItem(data = breed)
        }
    }
}

@Composable
private fun SearchLoading(modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun SearchError(
    error: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = error)
    }
}

@Composable
private fun SearchItem(
    data: BreedUi,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.onSecondary,
                shape = CircleShape
            )
    ) {
        Text(
            modifier = modifier.padding(16.dp),
            text = data.name
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun SearchScreenContentPreview() {
    val data = listOf(
        BreedUi(name = "Dog1"),
        BreedUi(name = "Dog2"),
        BreedUi(name = "Dog3")
    )

    SearchScreenContent(data = data)
}