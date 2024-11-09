package com.mnhyim.noteeey.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp,8.dp,8.dp,8.dp)
        ) {
            Text(
                text = "Category",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = ""
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = ""
                )
            }

        }
    }
}