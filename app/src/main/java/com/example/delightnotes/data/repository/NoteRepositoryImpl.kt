package com.example.delightnotes.data.repository

import com.example.delightnotes.Database
import com.example.delightnotes.domain.model.Note
import com.example.delightnotes.domain.repository.INoteRepository
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import note.LocalNote
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val database: Database) : INoteRepository {

    override suspend fun getNotes(): Flow<List<Note>> =
        database.noteQueries.selectAll()
            .asFlow()
            .mapToList()
            .map { value: List<LocalNote> -> value.map { Note(it.label, it.quantity) } }

    override suspend fun upsertNote(note: Note) {
        database.noteQueries.insertOrReplace(note.label, note.quantity)
    }

    override suspend fun deleteNoteByLabel() {
        TODO("Not yet implemented")
    }

    override suspend fun selectNoteByLabel() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllNotes() {
        database.noteQueries.drop()
    }
}