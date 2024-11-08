package com.mnhyim.noteeey.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnhyim.noteeey.ui.feature.home.HomeScreen
import com.mnhyim.noteeey.ui.feature.settings.SettingsScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoutes.Settings
    ) {
        composable<MainRoutes.Home> {
            HomeScreen()
        }
        composable<MainRoutes.Settings> {
            SettingsScreen()
        }
    }
}