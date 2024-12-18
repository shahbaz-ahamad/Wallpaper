package com.shahbaz.wallpaper.screen.homescreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shahbaz.wallpaper.screen.component.LoadingPlaceholder

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit
) {


    BackHandler { onBackPress() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(20) {
            LoadingPlaceholder(
                modifier = Modifier
                    .height(200.dp)
            )
        }
    }
}