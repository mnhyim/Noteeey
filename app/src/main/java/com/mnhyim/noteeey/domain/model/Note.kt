package com.mnhyim.noteeey.domain.model

import java.time.LocalDateTime

data class Note(
    val id: Long,
    val title: String,
    val content: String,
    val category: Category,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)