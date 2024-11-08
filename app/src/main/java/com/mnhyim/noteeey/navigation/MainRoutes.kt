package com.mnhyim.noteeey.navigation

import kotlinx.serialization.Serializable

sealed class MainRoutes {

    @Serializable
    object Home: MainRoutes()

    @Serializable
    object Settings: MainRoutes()

}