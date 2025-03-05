package com.example.bookbrew;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class BookStyleActivity extends AppCompatActivity {

    private RadioGroup colorGroup;
    private CheckBox boldCheckBox;
    private CheckBox italicCheckBox;
    private CheckBox underlineCheckBox;
    private DatePicker datePicker;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_style);

        initializeViews();
        setupConfirmButton();
    }

    private void initializeViews() {
        colorGroup = findViewById(R.id.colorRadioGroup);
        boldCheckBox = findViewById(R.id.boldCheckBox);
        italicCheckBox = findViewById(R.id.italicCheckBox);
        underlineCheckBox = findViewById(R.id.underlineCheckBox);
        datePicker = findViewById(R.id.datePicker);
        confirmButton = findViewById(R.id.confirmButton);
    }

    private void setupConfirmButton() {
        confirmButton.setOnClickListener(v -> showConfirmationDialog());
    }

    private void showConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmar alterações")
                .setMessage("Deseja confirmar as alterações realizadas?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    Intent intent = new Intent(BookStyleActivity.this, GraphicsActivity.class);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Não", null)
                .show();
    }
}
