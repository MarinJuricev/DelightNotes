package com.example.delightnotes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.delightnotes.databinding.ItemNoteBinding
import com.example.delightnotes.domain.model.Note

class NoteAdapter :
    ListAdapter<Note, NoteViewHolder>(NoteItemDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemLoadingBinding =
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NoteViewHolder(itemLoadingBinding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        if (currentList.isNotEmpty()) {
            getItem(position)?.let { userItem ->
                holder.bind(userItem)
            }
        }
    }
}

class NoteViewHolder(private val binding: ItemNoteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Note) {
        binding.noteLabel.text = data.label
        binding.noteQuantity.text = data.quantity.toString()
    }
}
