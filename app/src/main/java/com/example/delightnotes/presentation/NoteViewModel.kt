package com.example.delightnotes.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.delightnotes.domain.model.Note
import com.example.delightnotes.domain.repository.INoteRepository
import kotlinx.coroutines.launch
import java.util.*

class NoteViewModel @ViewModelInject constructor(
    private val noteRepository: INoteRepository
) : ViewModel() {

    fun getNotes() = liveData<List<Note>> {
        emitSource(noteRepository.getNotes().asLiveData(viewModelScope.coroutineContext))
    }

    fun addNote() = viewModelScope.launch {
        noteRepository.upsertNote(Note(generateRandomString(), 1))
    }

    private fun generateRandomString(): String {
        return sequence { val r = Random(); while (true) yield(r.nextInt(24)) }
            .take(10)
            .map { (it + 65).toChar() }
            .joinToString("")
    }

    fun dropNotes() = viewModelScope.launch {
        noteRepository.deleteAllNotes()
    }


}
