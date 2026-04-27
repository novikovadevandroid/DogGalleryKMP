package com.example.shared.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import com.example.shared.presentation.SearchScreen

object SearchNavGraph : BaseNavGraph {

    sealed interface Destination {

        @Serializable
        data object Root : Destination

        @Serializable
        data object Search : Destination
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Destination.Root>(startDestination = Destination.Search) {

            composable<Destination.Search> {
                SearchScreen(modifier, onClick = { breed ->
                    navController.navigate(DetailsNavGraph.Destination.Details(breed))
                })
            }
        }
    }
}