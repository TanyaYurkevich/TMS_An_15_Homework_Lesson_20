package com.example.tms_an_15_homework_lesson_20

import android.app.Activity
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import com.example.tms_an_15_homework_lesson_19_fin.R
import java.util.Date
import java.util.Locale

class CreatingNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creating_note)

        val button = findViewById<AppCompatButton>(R.id.cr_button)
        button.setOnClickListener {
            val titleCr = findViewById<AppCompatEditText>(R.id.cr_title)
            val textCr = findViewById<AppCompatEditText>(R.id.cr_text)
            val checkBox = findViewById<AppCompatCheckBox>(R.id.checkBox)
            val date = getCurrentDate()
            val title = titleCr.text.toString()
            val text = textCr.text.toString()
            val imageId: Int = R.drawable.checkmark

            if (title.isEmpty() && text.isEmpty()) {
                Toast.makeText(this, "No data to save", Toast.LENGTH_SHORT).show()
            }
            if (!title.isEmpty() || !text.isEmpty()) {
                val note = Note.ItemNote(date, title, text)
                val noteImp = Note.ImportantNote(date, title, text, imageId)
                // val intent = Intent()
                if (checkBox.isChecked) {
                    Intent().let {
                        it.putExtra(
                            Utils.NEW_IMP_NOTE, noteImp
                        )
                        setResult(Activity.RESULT_OK, it)
                    }

                } else {
                    Intent().let {
                        it.putExtra(
                            Utils.NEW_NOTE, note
                        )
                        setResult(Activity.RESULT_OK, it)
                    }
                }
                finish()
            }
        }
    }
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return dateFormat.format(Date())
    }
}



