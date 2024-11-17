package com.mnhyim.noteeey.ui.feature.addnote

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDropdown(
    selectedItemName: String,
    list: @Composable (() -> Unit) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    if (expanded) {
        Dialog(
            onDismissRequest = { expanded = false },
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.65f).dp)
            ) {
                list { expanded = false }
            }
        }
    }

    Box(
        modifier = modifier.height(IntrinsicSize.Min)
    ) {
        TextField(
            readOnly = true,
            value = selectedItemName,
            onValueChange = {},
            trailingIcon = {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                    contentDescription = "",
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.extraSmall)
                .clickable { expanded = true },
        )
    }
}

@Composable
fun CustomDropdownMenuItem(
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Unspecified,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    )
}