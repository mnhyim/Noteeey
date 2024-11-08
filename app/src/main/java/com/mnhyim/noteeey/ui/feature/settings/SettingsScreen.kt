package com.mnhyim.noteeey.ui.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        SettingsScreenContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun SettingsScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text("Settings Screen")
    }
}