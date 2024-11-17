package com.mnhyim.noteeey.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class NoteWithCategoryEntity(
    @Embedded val note: NoteEntity,
    @Relation(
        parentColumn = "note_category_id",
        entityColumn = "category_id"
    )
    val category: CategoryEntity
)