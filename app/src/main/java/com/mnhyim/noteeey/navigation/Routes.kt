package com.mnhyim.noteeey.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object Home : Routes()

    /* Settings Route */
    @Serializable
    object Settings : Routes()

    @Serializable
    object AddCategories : Routes()

    @Serializable
    object Appearances : Routes()

}