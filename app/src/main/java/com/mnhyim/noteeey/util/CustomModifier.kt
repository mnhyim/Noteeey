package com.mnhyim.noteeey.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/* Give active RTF formatting button a background */
fun Modifier.activeBackground(
    status: Boolean,
    color: Color,
    size: Dp = 40.dp
) = composed {
    then(
        if (status) {
            Modifier
                .background(
                    color,
                    CircleShape
                )
                .size(size)
        } else {
            Modifier
        }
    )
}