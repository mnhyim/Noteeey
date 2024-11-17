package com.mnhyim.noteeey.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "notes",
)
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    val id: Long = 0,

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_content")
    val content: String,

    @ColumnInfo(name = "note_category_id")
    val categoryId: Long,

    @ColumnInfo(name = "created_at")
    val createdAt: LocalDateTime,

    @ColumnInfo(name = "updated_at")
    val updatedAt: LocalDateTime
)