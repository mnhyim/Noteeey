package com.mnhyim.noteeey.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mnhyim.noteeey.domain.model.Note
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichText
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import kotlin.text.format

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier
) {
    val richTextState = rememberRichTextState()

    LaunchedEffect(Unit) {
        richTextState.setMarkdown(note.content)
    }

    Card(
        onClick = {}
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            RichText(
                state = richTextState,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            HorizontalDivider()
            Row(
                modifier = Modifier.padding(top = 6.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "[${note.category.name}]",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "[${convertLocalDateTime(note.createdAt)}]",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                )
            }
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteItemPreview(modifier: Modifier = Modifier) {
//    NoteeeyTheme {
//        NoteItem(modifier = modifier)
//    }
}

private fun convertLocalDateTime(date: LocalDateTime): String? {
    val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
    return date.format(formatter)
}