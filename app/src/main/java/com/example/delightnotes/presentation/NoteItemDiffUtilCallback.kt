package com.example.delightnotes.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.delightnotes.domain.model.Note

class NoteItemDiffUtilCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.label == newItem.label
    }

}
