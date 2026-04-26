package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.SubcomposeAsyncImage
import org.koin.compose.viewmodel.koinViewModel
import presentation.model.ImageUi

@Composable
fun DetailsScreen() {
    val viewModel = koinViewModel<DetailsViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when {
        uiState.isLoading -> {
            DetailsLoading()
        }

        uiState.data != null -> {
            uiState.data?.let { data ->
                DetailsScreenContent(data = data)
            }
        }

        uiState.error.isNotEmpty() -> {
            DetailsError(error = uiState.error)
        }
    }
}

@Composable
private fun DetailsLoading(modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun DetailsError(
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
private fun DetailsScreenContent(
    data: List<ImageUi>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(items = data) { img ->
            DetailsItem(data = img)
        }
    }
}

@Composable
private fun DetailsItem(
    data: ImageUi,
    modifier: Modifier = Modifier
) {
    if (data.url.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    color = MaterialTheme.colorScheme.onSecondary,
                    shape = CircleShape
                )
        )
    } else {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(400.dp)
                .background(
                    color = MaterialTheme.colorScheme.onSecondary,
                    shape = CircleShape
                )
        ) {
            SubcomposeAsyncImage(
                modifier = modifier
                    .fillMaxWidth()
                    .height(400.dp),
                model = data.url,
                contentDescription = null,
                loading = {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                },
                error = {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Ops")
                    }
                }
            )
        }
    }
}
