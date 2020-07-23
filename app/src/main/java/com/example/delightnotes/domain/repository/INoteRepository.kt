package com.example.delightnotes.domain.repository

import com.example.delightnotes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {
    suspend fun getNotes(): Flow<List<Note>>
    suspend fun upsertNote(note: Note)
    suspend fun deleteNoteByLabel()
    suspend fun selectNoteByLabel()
    suspend fun deleteAllNotes()
}