package com.mnhyim.noteeey.ui.feature.addnote

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.FormatItalic
import androidx.compose.material.icons.filled.FormatUnderlined
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.mohamedrejeb.richeditor.model.RichTextState

enum class RtfFormats(
    val text: String,
    val icon: ImageVector,
    val applyStyle: (RichTextState) -> Unit
) {
    BOLD(
        text = "Bold",
        icon = Icons.Default.FormatBold,
        applyStyle = { state -> state.toggleSpanStyle(SpanStyle(fontWeight = FontWeight.Bold)) }
    ),
    ITALIC(
        text = "Italic",
        icon = Icons.Default.FormatItalic,
        applyStyle = { state -> state.toggleSpanStyle(SpanStyle(fontStyle = FontStyle.Italic)) }
    ),
    UNDERLINED(
        text = "Underlined",
        icon = Icons.Default.FormatUnderlined,
        applyStyle = { state -> state.toggleSpanStyle(SpanStyle(textDecoration = TextDecoration.Underline)) }
    ),
//    TEXT_COLOR(text = "Text Color", icon = Icons.Default.FormatColorText),
//    FILL_COLOR(text = "Fill Color", icon = Icons.Default.FormatColorFill),

//    ORDERED_LIST(text = "Ordered List", icon = Icons.Default.FormatListNumbered),
//    UNORDERED_LIST(text = "Unordered List", icon = Icons.AutoMirrored.Default.FormatListBulleted),

//    LEFT_ALIGN(text = "Left Align", icon = Icons.AutoMirrored.Default.FormatAlignLeft),
//    CENTER_ALIGN(text = "Center Align", icon = Icons.Default.FormatAlignCenter),
//    RIGHT_ALIGN(text = "Right Align", icon = Icons.AutoMirrored.Default.FormatAlignRight),
//    JUSTIFY_ALIGN(text = "Justify Align", icon = Icons.Default.FormatAlignJustify)
}
