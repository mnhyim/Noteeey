package com.mnhyim.noteeey.domain.usecase

import com.mnhyim.noteeey.domain.model.Note
import com.mnhyim.noteeey.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note): Result<Unit> {
        return try {
            noteRepository.insertNote(note)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}