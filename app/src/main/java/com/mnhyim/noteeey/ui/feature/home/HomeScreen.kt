package com.mnhyim.noteeey.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mnhyim.noteeey.navigation.Routes
import com.mnhyim.noteeey.ui.components.CustomCenterAlignedTopAppBar
import com.mnhyim.noteeey.ui.components.NoteItem

@Composable
fun HomeScreen(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomCenterAlignedTopAppBar(
                title = "Noteeey",
                actions = {
                    IconButton(
                        onClick = { onNavigate(Routes.Settings) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = ""
                        )
                    }
                    IconButton(
                        onClick = { onNavigate(Routes.AddNote) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
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
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(10) {
                NoteItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .then(
                            if (it == 0) Modifier.padding(top = 8.dp)
                            else if (it == 9) Modifier.padding(bottom = 16.dp)
                            else Modifier
                        )
                )
            }
        }
    }
}