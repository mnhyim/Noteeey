package com.mnhyim.noteeey.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        HomeScreenContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text("Home Screen")
    }
}