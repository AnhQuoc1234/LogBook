package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText Value1, Value2;
    Spinner spinner1, spinner2;
    Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI components
        Value1 = findViewById(R.id.Value1);
        Value2 = findViewById(R.id.Value2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        buttonConvert = findViewById(R.id.buttonConvert);

        //  Click event
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLength();
            }
        });
    }

    private void convertLength() {
        String inputStr = Value1.getText().toString().trim();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue;
        try {
            inputValue = Double.parseDouble(inputStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
            return;
        }

        String fromUnit = spinner1.getSelectedItem().toString();
        String toUnit = spinner2.getSelectedItem().toString();

        double valueInMeters = convertToMeters(inputValue, fromUnit);
        double result = convertFromMeters(valueInMeters, toUnit);

        Value2.setText(String.format("%.4f", result));
    }

    private double convertToMeters(double value, String unit) {
        switch (unit) {
            case "Millimeter": return value / 1000.0;
            case "Centimeter": return value / 100.0;
            case "Meter": return value;
            case "Kilometer": return value * 1000.0;
            default: return value;
        }
    }

    private double convertFromMeters(double value, String unit) {
        switch (unit) {
            case "Millimeter": return value * 1000.0;
            case "Centimeter": return value * 100.0;
            case "Meter": return value;
            case "Kilometer": return value / 1000.0;
            default: return value;
        }
    }
}