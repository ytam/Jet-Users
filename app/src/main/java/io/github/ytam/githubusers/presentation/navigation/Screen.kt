package io.github.ytam.githubusers.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object UserDetails : Screen("details_screen")
}
