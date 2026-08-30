package com.frezzdev.todo

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var taskInput: EditText
    private lateinit var taskList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskInput = findViewById(R.id.taskInput)
        taskList = findViewById(R.id.taskList)

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            addTask()
        }
    }

    private fun addTask() {
        val title = taskInput.text.toString().trim()
        if (title.isEmpty()) return

        val checkBox = CheckBox(this).apply {
            text = title
            textSize = 16f
            setPadding(8, 12, 8, 12)
        }

        checkBox.setOnCheckedChangeListener { _, checked ->
            checkBox.alpha = if (checked) 0.55f else 1f
        }

        taskList.addView(checkBox)
        taskInput.text.clear()
    }
}
