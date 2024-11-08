package com.mnhyim.noteeey.navigation

import kotlinx.serialization.Serializable

sealed class SettingRoutes {

    @Serializable
    object AddCategories: SettingRoutes()

    @Serializable
    object Appearances: SettingRoutes()
}