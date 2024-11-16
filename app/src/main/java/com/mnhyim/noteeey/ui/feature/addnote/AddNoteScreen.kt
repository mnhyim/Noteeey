package com.mnhyim.noteeey.ui.feature.addnote

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.navigation.Routes
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditorDefaults
import java.time.LocalDateTime

@Composable
fun AddNoteScreen(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {

        },
        modifier = modifier
    ) { innerPadding ->
        AddNoteScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
                .imePadding()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddNoteScreenContent(
    modifier: Modifier = Modifier
) {
    val richTextState = rememberRichTextState()
    var title by remember { mutableStateOf("") }

    /* TODO: Temporary stuff */
    val categories = (0..19).map { index ->
        Category(
            id = index.toLong(),
            name = "Item ${index + 1}",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
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
                selectedItemName = if (selectedCategoryId == -1L) "Category" else categories[selectedCategoryId.toInt()].name,
                list = { closeDialog ->
                    LazyColumn {
                        items(items = categories, key = { it.id }) { category ->
                            CustomDropdownMenuItem(
                                text = category.name,
                                isSelected = selectedCategoryId == category.id,
                                onClick = {
                                    selectedCategoryId = category.id
                                    closeDialog()
                                }
                            )
                        }
                    }
                },
                modifier = Modifier.weight(1.5f)
            )
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
