package com.mnhyim.noteeey.data.util

import com.mnhyim.noteeey.data.entity.NoteEntity
import com.mnhyim.noteeey.data.entity.NoteWithCategoryEntity
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.model.Note

object NoteMapper {

    fun toEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = note.id,
            title = note.title,
            content = note.content,
            categoryId = note.category.id,
            createdAt = note.createdAt,
            updatedAt = note.updatedAt
        )
    }

    fun toModel(note: NoteWithCategoryEntity): Note {
        return Note(
            id = note.note.id,
            title = note.note.title,
            content = note.note.content,
            category = Category(
                id = note.category.id,
                name = note.category.name,
                createdAt = note.category.createdAt,
                updatedAt = note.category.updatedAt
            ),
            createdAt = note.note.createdAt,
            updatedAt = note.note.updatedAt
        )
    }
}