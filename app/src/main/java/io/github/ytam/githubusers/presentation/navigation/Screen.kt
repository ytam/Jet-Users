package io.github.ytam.githubusers.presentation.navigation

sealed class Screen(val route: String) {

    object Home : Screen("home_screen")

    object Details : Screen("details_screen/{username}") {
        fun passUsername(username: String) = "details_screen/$username"
    }
}
