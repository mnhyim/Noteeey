package com.mnhyim.noteeey.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnhyim.noteeey.ui.feature.home.HomeScreen
import com.mnhyim.noteeey.ui.feature.settings.SettingsScreen
import com.mnhyim.noteeey.ui.feature.settings.addcategories.AddCategoriesScreen
import com.mnhyim.noteeey.ui.feature.settings.appearances.AppearancesScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Settings
    ) {
        composable<Routes.Home> {
            HomeScreen()
        }

        /* Settings */
        composable<Routes.Settings> {
            SettingsScreen(
                onNavigate = { navController.navigate(it) }
            )
        }
        composable<Routes.AddCategories> {
            AddCategoriesScreen()
        }
        composable<Routes.Appearances> {
            AppearancesScreen()
        }
    }
}