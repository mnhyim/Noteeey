package com.mnhyim.noteeey.domain.usecase

import com.mnhyim.noteeey.domain.model.Note
import com.mnhyim.noteeey.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}