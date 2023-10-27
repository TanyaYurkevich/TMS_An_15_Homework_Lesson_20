package com.example.tms_an_15_homework_lesson_20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_20.Note
import com.example.tms_an_15_homework_lesson_19_fin.R

class NoteViewHolder(private val viewItem: View) : RecyclerView.ViewHolder(viewItem){
    fun bind(item: Note.ItemNote) {
        with(viewItem) {
            findViewById<TextView>(R.id.title).text = item.title
            findViewById<TextView>(R.id.text).text = item.text
            findViewById<TextView>(R.id.date).text = item.date
        }
    }
    companion object {
        fun from(parent: ViewGroup): NoteViewHolder {
            return NoteViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_note_layout, parent, false)
            )
        }
    }
}