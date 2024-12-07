package com.mnhyim.noteeey.ui.feature.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.ui.graphics.vector.ImageVector
import com.mnhyim.noteeey.ui.navigation.Routes

enum class SettingItemEntries(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val route: Routes
) {
    ADD_CATEGORIES(
        title = "Add Categories",
        subtitle = "Manage notes categories.",
        icon = Icons.Default.Category,
        route = Routes.AddCategories
    ),
    APPEARANCES(
        title = "Appearances",
        subtitle = "Change app's theme and other appearance settings.",
        icon = Icons.Default.ColorLens,
        route = Routes.Appearances
    )
}