package com.mnhyim.noteeey.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.mnhyim.noteeey.data.entity.NoteEntity
import com.mnhyim.noteeey.data.entity.NoteWithCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Transaction
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteWithCategoryEntity>>

//    @Query("SELECT * FROM notes")
//    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE note_id = :id")
    fun getNoteById(id: Long): NoteEntity

    @Query("SELECT * FROM notes WHERE note_category_id = :id")
    fun getNoteByCategory(id: Long): Flow<List<NoteEntity>>

    @Insert
    suspend fun insertNote(note: NoteEntity): Long

    @Update
    suspend fun updateNote(note: NoteEntity): Int

    @Delete
    suspend fun deleteNote(note: NoteEntity): Int
}