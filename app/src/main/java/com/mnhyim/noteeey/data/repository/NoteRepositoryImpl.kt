package com.mnhyim.noteeey.data.repository

import com.mnhyim.noteeey.data.dao.NoteDao
import com.mnhyim.noteeey.data.util.NoteMapper
import com.mnhyim.noteeey.domain.model.Note
import com.mnhyim.noteeey.domain.repository.NoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val noteDao: NoteDao
) : NoteRepository {

    override suspend fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { items ->
            items.map { item ->
                NoteMapper.toModel(item)
            }
        }
    }

    override fun getNoteById() {
        TODO("Not yet implemented")
    }

    override fun getNoteByCategory() {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: Note): Long {
        return withContext(ioDispatcher) {
            noteDao.insertNote(
                NoteMapper.toEntity(note)
            )
        }
    }

    override suspend fun updateNote() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote() {
        TODO("Not yet implemented")
    }


}