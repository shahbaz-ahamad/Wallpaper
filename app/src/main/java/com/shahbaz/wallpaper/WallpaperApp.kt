package com.shahbaz.wallpaper

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shahbaz.wallpaper.routs.Routs
import com.shahbaz.wallpaper.screen.category.CategoryScreen
import com.shahbaz.wallpaper.screen.component.BottomNavigationbar
import com.shahbaz.wallpaper.screen.favourite.FavouriteScreen
import com.shahbaz.wallpaper.screen.homescreen.HomeScreen
import com.shahbaz.wallpaper.screen.setting.SettingScreen
import com.shahbaz.wallpaper.screen.splashscreen.SplashScreen
import kotlin.system.exitProcess

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun WallpaperApp() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationbar(navHostController = navController)
        },

        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->

        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = Routs.Splash,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

                composable<Routs.Splash> {
                    SplashScreen(
                        onNavigateToHome = {
                            navController.navigate(
                                Routs.Home,
                                navOptions = NavOptions.Builder().setPopUpTo(Routs.Splash, true)
                                    .build()
                            )
                        }
                    )
                }

                composable<Routs.Home> {
                    HomeScreen(
                        onBackPress = {
                            //exit from the app
                            exitProcess(0)
                        }
                    )
                }

                composable<Routs.Category> {
                    CategoryScreen(
                        onBackPress = {
                            //navigate to home screen
                            navController.navigate(Routs.Home)
                        }
                    )
                }

                composable<Routs.Setting> {
                    SettingScreen(
                        onBackPress = {
                            //navigate to home screen
                            navController.navigate(Routs.Home)
                        }
                    )
                }

                composable<Routs.Favourite> {
                    FavouriteScreen(
                        onBackPress = {
                            //navigate to home screen
                            navController.navigate(Routs.Home)
                        }
                    )
                }
            }
        }
    }
}
