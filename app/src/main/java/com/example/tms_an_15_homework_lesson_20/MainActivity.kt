package com.example.tms_an_15_homework_lesson_20

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_19_fin.R
import com.example.tms_an_15_homework_lesson_20.adapter.NoteViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        // recyclerView.layoutManager = LinearLayoutManager(this) - в xml есть
        val adapter = NoteViewAdapter()
        recyclerView.adapter = adapter

        /** adapter.setOnItemClick {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra(Utils.DETAIL_NOTE, intent)
        startActivity(intent)
        }
         */

        adapter.setOnItemClick { note ->
            val note = "${note.toString()}"
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, note)
            }
            val chooser = Intent.createChooser(intent, "")
            startActivity(chooser)
        }


        val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                val newNote =
                    it.data?.getParcelableExtra<Note.ImportantNote>(Utils.NEW_IMP_NOTE)
                        ?: it.data?.getParcelableExtra<Note.ItemNote>(Utils.NEW_NOTE)
                if (newNote != null) {
                    adapter.addItemList(newNote)
                }
            }

        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener {
            activityResultLauncher.launch(Intent(this, CreatingNote::class.java))
        }
    }
}


