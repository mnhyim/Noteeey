package com.mnhyim.noteeey.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mnhyim.noteeey.ui.theme.NoteeeyTheme

@Composable
fun NoteItem(
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {},
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Four Words Long Title",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall
            )
//            HorizontalDivider(
//                thickness = 0.5.dp,
//                color = Color.Gray,
//                modifier = Modifier.padding(top = 6.dp, bottom = 4.dp)
//            )
            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Uncategorized",
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "22 August 2023",
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NoteItemPreview(modifier: Modifier = Modifier) {
    NoteeeyTheme {
        NoteItem(modifier = modifier)
    }
}