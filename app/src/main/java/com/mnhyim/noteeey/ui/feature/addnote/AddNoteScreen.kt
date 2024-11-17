package com.mnhyim.noteeey.ui.feature.addnote

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.navigation.Routes
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditorDefaults

@Composable
fun AddNoteScreen(
    onNavigate: (Routes) -> Unit,
    viewModel: AddNoteViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val categories by viewModel.categories.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { },
        modifier = modifier
    ) { innerPadding ->

        AddNoteScreenContent(
            categories = categories,
            onSaveNote = { title, content, id -> viewModel.saveNote(title, content, id) },
            modifier = Modifier
                .consumeWindowInsets(innerPadding)
                .imePadding()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddNoteScreenContent(
    categories: List<Category>,
    onSaveNote: (String, String, Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val richTextState = rememberRichTextState()
    var title by remember { mutableStateOf("") }
    var selectedCategoryId by remember { mutableLongStateOf(-1) }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 4.dp)
            )
            CustomDropdown(
                selectedItemName = if (selectedCategoryId == -1L) "Category" else categories.first { it.id == selectedCategoryId }.name,
                list = { closeDialog ->
                    LazyColumn {
                        itemsIndexed(
                            items = categories,
                            key = { _, item -> item.id }) { index, category ->
                            CustomDropdownMenuItem(
                                text = category.name,
                                isSelected = selectedCategoryId == category.id,
                                onClick = {
                                    selectedCategoryId = category.id
                                    closeDialog()
                                }
                            )
                            if (index != categories.size - 1) {
                                HorizontalDivider()
                            }
                        }
                    }
                },
                modifier = Modifier.weight(1.5f)
            )
        }
        Button(onClick = { onSaveNote(title, richTextState.toMarkdown(), selectedCategoryId) }) {
            Text("Save Note")
        }
        Box {
            RichTextEditor(
                state = richTextState,
                colors = RichTextEditorDefaults.richTextEditorColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxSize(),
                contentPadding = RichTextEditorDefaults.richTextEditorWithLabelPadding(bottom = 74.dp)
            )
            RtfStyleBar(
                state = richTextState,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(4.dp)
            )
        }


    }
}
