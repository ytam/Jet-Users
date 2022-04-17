package io.github.ytam.githubusers.presentation.screen.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.ytam.githubusers.R

@Composable
fun DetailsTopBar(navController: NavController) {
    TopAppBar(
        title = { Text("Details") },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = colorResource(id = R.color.black),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .clickable {
                        navController.navigateUp()
                    }
            )
        }
    )
}
