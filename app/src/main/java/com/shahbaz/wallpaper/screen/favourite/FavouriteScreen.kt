package com.shahbaz.wallpaper.screen.favourite

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit
) {

    BackHandler {
        onBackPress()
    }
}