package com.shahbaz.wallpaper.screen.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun ShimmerBrush(
    showShimmer: Boolean = true,
    targetValue: Float = 1000f,
): Brush {
    return if (showShimmer) {
        val shimmerColor = listOf(
            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f),
            MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
        )
        val transition = rememberInfiniteTransition(label = "Shimmer")
        val transitionAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            label = "Shimmer",
            animationSpec = infiniteRepeatable(
                animation = tween(1200),
                repeatMode = RepeatMode.Restart
            )
        )
        Brush.linearGradient(
            colors = shimmerColor,
            start = Offset.Zero,
            end = Offset(x = transitionAnimation.value, y = transitionAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}