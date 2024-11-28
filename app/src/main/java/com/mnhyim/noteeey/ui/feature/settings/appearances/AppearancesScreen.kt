package com.mnhyim.noteeey.ui.feature.settings.appearances

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.noteeey.ui.components.CustomTopAppBar

@Composable
fun AppearancesScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(title = "Appearances", onBack = {})
        }
    ) { innerPadding ->
        AppearancesScreenContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun AppearancesScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text("Appearances")
    }
}