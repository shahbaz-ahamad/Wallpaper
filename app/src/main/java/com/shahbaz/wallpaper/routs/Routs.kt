package com.shahbaz.wallpaper.routs

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routs {

    @Serializable
    data object Splash : Routs

    @Serializable
    data object Home : Routs

    @Serializable
    data object Category : Routs

    @Serializable
    data object Setting : Routs

    @Serializable
    data object Favourite : Routs
}