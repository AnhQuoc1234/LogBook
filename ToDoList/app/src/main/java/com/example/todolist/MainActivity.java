package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button addButton;

    ArrayList<Task> taskList;
    ArrayList<String> displayList;
    ArrayAdapter<String> adapter;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        addButton = findViewById(R.id.button);
        dbHelper = new DatabaseHelper(this);

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        // Long press to delete
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Task task = taskList.get(position);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Delete Task")
                    .setMessage("Are you sure you want to delete this task?")
                    .setPositiveButton("Delete", (dialog, which) -> {
                        dbHelper.deleteTask(task.getId());
                        loadTasks(); // Refresh list
                    })
                    .setNegativeButton("Cancel", null)
                    .show();

            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTasks();
    }

    private void loadTasks() {
        taskList = dbHelper.getAllTasks();
        displayList = new ArrayList<>();

        for (Task task : taskList) {
            displayList.add(formatTask(task));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
    }

    private String formatTask(Task task) {
        return "📌 " + task.getName() +
                "\n⏰ " + task.getDeadline() + " | " + task.getDuration() + " hrs" +
                "\n📝 " + task.getDescription();
    }
}