package com.mnhyim.noteeey.ui.feature.settings.addcategories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mnhyim.noteeey.ui.components.CategoryItem
import com.mnhyim.noteeey.ui.components.CustomTopAppBar

@Composable
fun AddCategoriesScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Add Categories",
                onBack = {},
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
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
        AddCategoriesScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
    }
}

@Composable
private fun AddCategoriesScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(20) {
                CategoryItem(
                    modifier = Modifier
                        .then(
                            if (it == 19) Modifier.padding(bottom = 16.dp)
                            else Modifier
                        )
                )
            }
        }
    }
}