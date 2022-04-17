package io.github.ytam.githubusers.presentation.screen.home.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ytam.githubusers.presentation.theme.AppContentColor
import io.github.ytam.githubusers.presentation.theme.AppThemeColor

@Composable
fun HomeTopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        title = {
            Text(
                text = "Jet Users",
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5
            )
        },
        elevation = 0.dp
    )
}

@Preview
@Composable
fun DefaultPreview() {
    HomeTopBar()
}
