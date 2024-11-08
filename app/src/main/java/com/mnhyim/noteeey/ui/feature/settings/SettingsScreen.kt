package com.mnhyim.noteeey.ui.feature.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mnhyim.noteeey.ui.components.CustomCenterAlignedTopAppBar
import com.mnhyim.noteeey.ui.components.SettingItem

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomCenterAlignedTopAppBar(
                title = "Settings"
            )
        }
    ) { innerPadding ->
        SettingsScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
        LazyColumn {
            items(items = SettingItemEntries.entries.toTypedArray()) {
                SettingItem(
                    title = it.title,
                    subtitle = it.subtitle,
                    icon = it.icon,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { })
                        .padding(16.dp)
                )
            }
        }
    }
}