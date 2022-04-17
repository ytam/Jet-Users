package io.github.ytam.githubusers.presentation.screen.details.view

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.github.ytam.githubusers.presentation.screen.details.components.DetailsContent
import io.github.ytam.githubusers.presentation.screen.details.components.DetailsTopBar
import io.github.ytam.githubusers.presentation.screen.details.viewmodel.DetailsViewModel
import io.github.ytam.githubusers.presentation.theme.AppContentColor
import io.github.ytam.githubusers.presentation.theme.AppThemeColor

@Composable
fun DetailsScreen(
    username: String,
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    viewModel.getUserDetails(username = username)
    val userDetails by viewModel.selectedMovie.collectAsState()

    Scaffold(
        topBar = {
            DetailsTopBar(navController)
        },
        contentColor = MaterialTheme.colors.AppContentColor,
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        content = {
            userDetails?.let { DetailsContent(it) }
        }
    )
}
