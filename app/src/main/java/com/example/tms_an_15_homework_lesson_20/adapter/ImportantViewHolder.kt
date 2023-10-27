package com.example.tms_an_15_homework_lesson_20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_20.Note
import com.example.tms_an_15_homework_lesson_19_fin.R

class ImportantViewHolder (private val viewItem: View) : RecyclerView.ViewHolder(viewItem){
    fun bind(item: Note.ImportantNote) {
        with(viewItem) {
            findViewById<TextView>(R.id.title_i).text = item.title
            findViewById<TextView>(R.id.text_i).text = item.text
            findViewById<TextView>(R.id.date_i).text = item.date
            findViewById<ImageView>(R.id.image_i).setImageResource(
                R.drawable.checkmark)
        }
    }
    companion object{
        fun from(parent: ViewGroup): NoteViewHolder {
            return NoteViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.important_note_layout,parent,false)
            )
        }
    }
}

