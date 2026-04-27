package com.example.shared.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.shared.presentation.navigation.BaseNavGraph
import com.example.shared.presentation.navigation.DetailsNavGraph
import com.example.shared.presentation.navigation.SearchNavGraph

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeDrawingPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = SearchNavGraph.Destination.Root
            ) {
                listOf<BaseNavGraph>(
                    SearchNavGraph,
                    DetailsNavGraph
                ).forEach {
                    it.build(
                        modifier = Modifier,
                        navController = navController,
                        navGraphBuilder = this
                    )
                }
            }
        }
    }
}