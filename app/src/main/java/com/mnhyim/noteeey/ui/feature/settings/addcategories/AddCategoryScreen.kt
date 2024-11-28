package com.mnhyim.noteeey.ui.feature.settings.addcategories

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.ui.components.CategoryItem
import com.mnhyim.noteeey.ui.components.CustomDialog
import com.mnhyim.noteeey.ui.components.CustomTopAppBar

@Composable
fun AddCategoryScreen(
    viewModel: AddCategoryViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    var showAddCategoryDialog by remember { mutableStateOf(false) }

    val categories by viewModel.categories.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Add Categories",
                onBack = { },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddCategoryDialog = true },
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        AnimatedVisibility(
            visible = showAddCategoryDialog,
            exit = ExitTransition.None
        ) {
            var categoriesName by remember { mutableStateOf("") }

            CustomDialog(
                title = "Add Categories",
                content = {
                    OutlinedTextField(
                        value = categoriesName,
                        onValueChange = { categoriesName = it },
                        label = {
                            Text(
                                text = "Name",
                                style = MaterialTheme.typography.titleSmall,
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Category's name",
                                style = MaterialTheme.typography.labelSmall,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 8.dp)
                    )
                },
                onConfirm = {
                    if (categoriesName.isNotBlank()) {
                        viewModel.addCategory(categoriesName)
                        showAddCategoryDialog = false
                    }
                },
                onCancel = { showAddCategoryDialog = false },
                onDismiss = { showAddCategoryDialog = false },
            )
        }

        AddCategoryScreenContent(
            categories = categories,
            onDelete = { viewModel.deleteCategory(it) },
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
    }
}

@Composable
private fun AddCategoryScreenContent(
    categories: List<Category>,
    onDelete: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            itemsIndexed(
                items = categories,
                key = { _, category -> category.id }) { index, category ->
                CategoryItem(
                    category = category,
                    onDelete = { onDelete(category) },
                    modifier = Modifier
                        .then(
                            if (index == categories.size) Modifier.padding(bottom = 16.dp)
                            else Modifier
                        )
                )
            }
        }
    }
}

