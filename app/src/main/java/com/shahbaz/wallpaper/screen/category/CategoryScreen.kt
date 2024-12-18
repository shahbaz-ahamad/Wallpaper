package com.shahbaz.wallpaper.screen.category

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit
) {

    BackHandler {
        onBackPress()
    }
}