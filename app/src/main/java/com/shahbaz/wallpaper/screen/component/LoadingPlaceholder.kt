package com.shahbaz.wallpaper.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingPlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                ShimmerBrush(
                    showShimmer = true,
                    targetValue = 1300f
                )
            )
    )
}