package com.mnhyim.noteeey.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object Home : Routes()

    @Serializable
    object AddNote : Routes()

    @Serializable
    object Settings : Routes()

    /* Settings Route */
    @Serializable
    object AddCategories : Routes()

    @Serializable
    object Appearances : Routes()

}