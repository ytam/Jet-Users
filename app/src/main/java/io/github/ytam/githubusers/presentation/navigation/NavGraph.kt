package io.github.ytam.githubusers.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.github.ytam.githubusers.common.Constants
import io.github.ytam.githubusers.presentation.screen.details.view.DetailsScreen
import io.github.ytam.githubusers.presentation.screen.home.view.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(Constants.USER_DETAILS) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constants.USER_DETAILS)
                ?.let { DetailsScreen(it, navController) }
        }
    }
}
