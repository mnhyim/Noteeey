package com.mnhyim.noteeey.ui.feature.addnote

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.mnhyim.noteeey.util.activeBackground
import com.mohamedrejeb.richeditor.model.RichTextState

@Composable
fun RtfStyleBar(
    state: RichTextState,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp)
        ) {
            RtfFormats.entries.forEach { format ->
                RtfButton(
                    icon = format.icon,
                    onClick = { format.applyStyle(state) },
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(40.dp)
                        .activeBackground(
                            status = isFormatActive(state, format),
                            color = MaterialTheme.colorScheme.surfaceContainerHigh,
                            size = 40.dp
                        )
                )
            }
        }
    }
}

private fun isFormatActive(state: RichTextState, format: RtfFormats): Boolean {
    return when (format) {
        RtfFormats.BOLD -> state.currentSpanStyle.fontWeight == FontWeight.Bold
        RtfFormats.ITALIC -> state.currentSpanStyle.fontStyle == FontStyle.Italic
        RtfFormats.UNDERLINED -> state.currentSpanStyle.textDecoration == TextDecoration.Underline
    }
}