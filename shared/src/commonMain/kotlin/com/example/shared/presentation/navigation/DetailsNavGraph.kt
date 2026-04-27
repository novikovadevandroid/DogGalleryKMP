package com.example.shared.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import com.example.shared.presentation.DetailsScreen

object DetailsNavGraph : BaseNavGraph {

    sealed interface Destination {

        @Serializable
        data object Root : Destination

        @Serializable
        data class Details(val breed: String) : Destination
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Destination.Root>(startDestination = Destination.Details::class) {

            composable<Destination.Details> { navBackStack ->
                val breed = navBackStack.toRoute<Destination.Details>().breed

                DetailsScreen(modifier = modifier, breed = breed)
            }
        }
    }
}