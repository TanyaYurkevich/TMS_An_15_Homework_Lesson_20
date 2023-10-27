package com.example.tms_an_15_homework_lesson_20

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.tms_an_15_homework_lesson_19_fin.R

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val note = intent.getParcelableExtra<Note.ItemNote>(Utils.DETAIL_NOTE)
        if (note != null) {
            val dateDt = findViewById<EditText>(R.id.dt_date)
            val titleDt = findViewById<AppCompatEditText>(R.id.dt_title)
            val textDt = findViewById<AppCompatEditText>(R.id.dt_text)

            dateDt.setText(note.date)
            titleDt.setText(note.title)
            textDt.setText(note.text)
        }

        val note1 = intent.getParcelableExtra<Note.ImportantNote>(Utils.DETAIL_NOTE)
        if (note1 != null) {
            val dateDt = findViewById<EditText>(R.id.dt_date)
            val titleDt = findViewById<AppCompatEditText>(R.id.dt_title)
            val textDt = findViewById<AppCompatEditText>(R.id.dt_text)

            dateDt.setText(note1.date)
            titleDt.setText(note1.title)
            textDt.setText(note1.text)
        }
    }
}


