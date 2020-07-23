package com.example.delightnotes.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.delightnotes.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class NoteActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteAdapter = NoteAdapter()
        note_recycler_view.adapter = noteAdapter

        noteViewModel.getNotes().observe(this, Observer { noteAdapter.submitList(it) })

        add_note.setOnClickListener { noteViewModel.addNote() }
        delete_notes.setOnClickListener { noteViewModel.dropNotes() }
    }
}