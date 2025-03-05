package com.example.bookbrew;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class FinalActivity extends AppCompatActivity {
    private EditText finalComments;

    private Button finishButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown_item,
                items
        );
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setText(items[0], false);

        finalComments = findViewById(R.id.finalComments);
        finishButton = findViewById(R.id.finishButton);

        // Set max length for final comments
        finalComments.setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(200)
        });

        finishButton.setOnClickListener(v -> {
            Intent intent = new Intent(FinalActivity.this, ProcessingFinalActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void setupSpinner() {
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setText(items[0], false);
    }
}
