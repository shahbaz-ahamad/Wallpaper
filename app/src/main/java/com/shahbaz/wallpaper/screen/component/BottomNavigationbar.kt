package com.shahbaz.wallpaper.screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shahbaz.wallpaper.routs.IconType
import com.shahbaz.wallpaper.routs.bottomNavigationItems

@Composable
fun BottomNavigationbar(navHostController: NavHostController) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        bottomNavigationItems.forEach { bottomNavItem ->

            val isSelected =
                currentDestination?.hierarchy?.any { it.route == bottomNavItem.route::class.qualifiedName } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navHostController.navigate(bottomNavItem.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true // Save state when navigating
                        }
                        launchSingleTop = true // Avoid multiple copies of the same destination
                        restoreState = true // Restore the state if possible
                    }
                }
                ,
                icon = {
                    when (bottomNavItem.icon) {
                        is IconType.Drawable -> {
                            Icon(
                                painter = painterResource(
                                    id = if (isSelected && bottomNavItem.selectedIcon is IconType.Drawable) bottomNavItem.selectedIcon.iconRes else bottomNavItem.icon.iconRes,
                                ),
                                contentDescription = bottomNavItem.label
                            )
                        }

                        is IconType.Vector -> {
                            Icon(
                                imageVector = if (isSelected && bottomNavItem.selectedIcon is IconType.Vector)
                                    bottomNavItem.selectedIcon.icon
                                else bottomNavItem.icon.icon,
                                contentDescription = bottomNavItem.label,
                            )
                        }
                    }
                },
                alwaysShowLabel = false
            )
        }

    }
}