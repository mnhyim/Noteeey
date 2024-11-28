package com.mnhyim.noteeey.domain.repository

import com.mnhyim.noteeey.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun getAllNotes(): Flow<List<Note>>
    fun getNoteById()
    fun getNoteByCategory()
    suspend fun insertNote(note: Note): Long
    suspend fun updateNote()
    suspend fun deleteNote()
}