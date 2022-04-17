package io.github.ytam.githubusers.presentation.screen.home.view

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.ytam.githubusers.presentation.screen.home.view.components.HomeTopBar
import io.github.ytam.githubusers.presentation.screen.home.view.components.UserListContent
import io.github.ytam.githubusers.presentation.screen.home.viewmodel.HomeViewModel
import io.github.ytam.githubusers.presentation.theme.AppContentColor
import io.github.ytam.githubusers.presentation.theme.AppThemeColor

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val allUsers = viewModel.getAllUsers.collectAsLazyPagingItems()

    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        topBar = {
            HomeTopBar()
        },
        content = {
            UserListContent(allUsers = allUsers, navController = navController)
        }
    )
}
