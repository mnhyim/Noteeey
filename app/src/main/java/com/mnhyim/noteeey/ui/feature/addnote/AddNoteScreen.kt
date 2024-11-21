package com.mnhyim.noteeey.ui.feature.addnote

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.ui.components.CustomDropdown
import com.mnhyim.noteeey.ui.components.CustomDropdownMenuItem
import com.mnhyim.noteeey.ui.components.RtfStyleBar
import com.mnhyim.noteeey.ui.navigation.Routes
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditorDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    onNavigate: (Routes) -> Unit,
    viewModel: AddNoteViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val categories by viewModel.categories.collectAsStateWithLifecycle()

    val richTextState = rememberRichTextState()
    val noteEditorState by viewModel.noteEditorState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Add Note")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(
                        enabled = noteEditorState.title.isNotBlank() && noteEditorState.categoryId != -1L,
                        onClick = {
                            viewModel.onEvent(NoteEditorEvent.SaveNote(richTextState.toMarkdown()))
                            onNavigate(Routes.Home)
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Save, contentDescription = "")
                    }
                },
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        AddNoteScreenContent(
            categories = categories,
            richTextState = richTextState,
            noteEditorState = noteEditorState,
            noteEditorEvent = { viewModel.onEvent(it) },
            modifier = Modifier
                .padding(innerPadding)
                .imePadding()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddNoteScreenContent(
    categories: List<Category>,
    richTextState: RichTextState,
    noteEditorState: NoteEditorState,
    noteEditorEvent: (NoteEditorEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(
                text = "Title",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            TextField(
                value = noteEditorState.title,
                onValueChange = { noteEditorEvent(NoteEditorEvent.EditTitle(it)) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(
                text = "Category",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            CustomDropdown(
                selectedItemName = if (noteEditorState.categoryId == -1L) "Category" else categories.first { it.id == noteEditorState.categoryId }.name,
                list = { closeDialog ->
                    LazyColumn {
                        itemsIndexed(
                            items = categories,
                            key = { _, item -> item.id }) { index, category ->
                            CustomDropdownMenuItem(
                                text = category.name,
                                isSelected = noteEditorState.categoryId == category.id,
                                onClick = {
                                    noteEditorEvent(NoteEditorEvent.SelectCategory(category.id))
                                    closeDialog()
                                }
                            )
                            if (index != categories.size - 1) {
                                HorizontalDivider()
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column {
            Text(
                text = "Note",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Box {
                RichTextEditor(
                    state = richTextState,
                    colors = RichTextEditorDefaults.richTextEditorColors(
                        focusedIndicatorColor = Color.Unspecified,
                        unfocusedIndicatorColor = Color.Unspecified,
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = RichTextEditorDefaults.richTextEditorWithLabelPadding(bottom = 74.dp)
                )
                RtfStyleBar(
                    state = richTextState,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(8.dp)
                )
            }
        }
    }
}
