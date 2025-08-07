package com.example.todolist1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    EditText nameInput, deadlineInput, durationInput, descriptionInput;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        nameInput = findViewById(R.id.editTextName);
        deadlineInput = findViewById(R.id.editTextDeadline);
        durationInput = findViewById(R.id.editTextDuration);
        descriptionInput = findViewById(R.id.editTextDescription);
        saveButton = findViewById(R.id.buttonSave);

        saveButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String deadline = deadlineInput.getText().toString().trim();
            String duration = durationInput.getText().toString().trim();
            String description = descriptionInput.getText().toString().trim();

            if (!name.isEmpty()) {
                Task task = new Task(name, deadline, duration, description);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("task", task);
                setResult(RESULT_OK, resultIntent);
            }

            finish();
        });
    }
}
