package com.shahbaz.wallpaper.screen.setting

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit
) {

    BackHandler {
        onBackPress()
    }
}