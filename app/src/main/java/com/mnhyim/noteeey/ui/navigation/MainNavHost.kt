package com.mnhyim.noteeey.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnhyim.noteeey.ui.feature.addnote.AddNoteScreen
import com.mnhyim.noteeey.ui.feature.home.HomeScreen
import com.mnhyim.noteeey.ui.feature.settings.SettingsScreen
import com.mnhyim.noteeey.ui.feature.settings.addcategories.AddCategoryScreen
import com.mnhyim.noteeey.ui.feature.settings.appearances.AppearancesScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home
    ) {
        composable<Routes.Home> {
            HomeScreen(
                onNavigate = { navController.navigate(it) }
            )
        }

        composable<Routes.Settings> {
            SettingsScreen(
                onNavigate = { navController.navigate(it) }
            )
        }

        composable<Routes.AddNote> {
            AddNoteScreen(
                onNavigate = { navController.navigate(it) }
            )
        }

        /* Settings */
        composable<Routes.AddCategories> {
            AddCategoryScreen()
        }
        composable<Routes.Appearances> {
            AppearancesScreen()
        }
    }
}