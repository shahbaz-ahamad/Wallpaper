package com.shahbaz.wallpaper.routs

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.shahbaz.wallpaper.R

sealed interface IconType {
    data class Vector(val icon: ImageVector) : IconType
    data class Drawable(@DrawableRes val iconRes: Int) : IconType
}

data class BottomNavigationRoute(
    val route: Routs,
    val icon: IconType,
    val label: String,
    val selectedIcon: IconType
)


val bottomNavigationItems = listOf(
    BottomNavigationRoute(
        route = Routs.Home,
        icon = IconType.Vector(Icons.Outlined.Home),
        label = "Home",
        selectedIcon = IconType.Vector(Icons.Filled.Home)
    ),
    BottomNavigationRoute(
        route = Routs.Category,
        icon = IconType.Drawable(R.drawable.category),
        label = "Category",
        selectedIcon = IconType.Drawable(R.drawable.category_filled)
    ),
    BottomNavigationRoute(
        route = Routs.Favourite,
        icon = IconType.Vector(Icons.Outlined.FavoriteBorder),
        label = "Favourite",
        selectedIcon = IconType.Vector(Icons.Filled.Favorite)
    ),
    BottomNavigationRoute(
        route = Routs.Setting,
        icon = IconType.Vector(Icons.Outlined.Settings),
        label = "Setting",
        selectedIcon = IconType.Vector(Icons.Filled.Settings)
    )

)