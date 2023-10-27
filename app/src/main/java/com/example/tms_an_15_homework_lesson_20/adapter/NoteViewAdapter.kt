package com.example.tms_an_15_homework_lesson_20.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_20.Note

class NoteViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClicker: ((Note) -> Unit)? = null
    private val noteList = mutableListOf<Note>()
    fun addItemList(note: Note) {
       if (note is Note.ItemNote || note is Note.ImportantNote) {
          noteList.add(note)
       }
       notifyItemInserted(noteList.lastIndex)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return if (viewType == ITEM_NOTE) {
            NoteViewHolder.from(parent)
        } else {
            ImportantViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val note = noteList[position]
        if (holder is NoteViewHolder && note is Note.ItemNote) {
            holder.bind(note)
        } else if (holder is ImportantViewHolder && note is Note.ImportantNote) {
            holder.bind(note)
        } else {
            throw IllegalStateException()
        }
        holder.itemView.setOnClickListener { onItemClicker?.invoke(note)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun getItemViewType(position: Int): Int {
        val note = noteList[position]
        return when (note) {
            is Note.ItemNote -> ITEM_NOTE
            is Note.ImportantNote -> IMPORTANT_NOTE
        }
    }
    fun setOnItemClick(listener: (Note) -> Unit) {
        onItemClicker = listener
    }


    companion object {
        private const val ITEM_NOTE = 1
        private const val IMPORTANT_NOTE = 2
    }
}

