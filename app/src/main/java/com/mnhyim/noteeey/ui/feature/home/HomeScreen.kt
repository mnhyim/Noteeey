package com.mnhyim.noteeey.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.noteeey.domain.model.Note
import com.mnhyim.noteeey.ui.navigation.Routes
import com.mnhyim.noteeey.ui.components.CustomCenterAlignedTopAppBar
import com.mnhyim.noteeey.ui.components.NoteItem

@Composable
fun HomeScreen(
    onNavigate: (Routes) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val notes by viewModel.notes.collectAsStateWithLifecycle()

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
            notes = notes,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun HomeScreenContent(
    notes: List<Note>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items = notes, key = { _, note -> note.id }) { index, note ->
                NoteItem(
                    note = note,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .then(
                            if (index == 0) Modifier.padding(top = 8.dp)
                            else if (index == notes.size - 1) Modifier.padding(bottom = 16.dp)
                            else Modifier
                        )
                )
            }
        }
    }
}