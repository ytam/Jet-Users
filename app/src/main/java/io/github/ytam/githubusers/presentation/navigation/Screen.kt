package io.github.ytam.githubusers.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object UserDetails : Screen("user_details_screen/{movieId}") {
        fun passUsername(username: String) = "user_details_screen/$username"
    }
}
