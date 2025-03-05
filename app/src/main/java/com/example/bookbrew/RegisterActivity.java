package com.example.bookbrew;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameInput;
    private EditText lastNameInput;
    private EditText cpfInput;
    private EditText phoneInput;
    private EditText emailInput;
    private DatePicker birthDatePicker;
    private RadioGroup genderGroup;
    private Spinner preferencesSpinner;
    private Button clearButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();
        setupSpinner();
        setupButtons();
    }

    private void initializeViews() {
        nameInput = findViewById(R.id.nameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        cpfInput = findViewById(R.id.cpfInput);
        phoneInput = findViewById(R.id.phoneInput);
        emailInput = findViewById(R.id.emailInput);
        birthDatePicker = findViewById(R.id.birthDatePicker);
        genderGroup = findViewById(R.id.genderGroup);
        preferencesSpinner = findViewById(R.id.preferencesSpinner);
        clearButton = findViewById(R.id.clearButton);
        registerButton = findViewById(R.id.registerButton);
    }

    private void setupSpinner() {
        String[] preferences = {"Romance", "Ficção", "Terror", "Aventura", "Biografia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, preferences);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        preferencesSpinner.setAdapter(adapter);
    }

    private void setupButtons() {
        clearButton.setOnClickListener(v -> showClearConfirmationDialog());
        registerButton.setOnClickListener(v -> validateAndRegister());
    }

    private void showClearConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Limpar campos")
                .setMessage("Deseja realmente limpar todos os campos?")
                .setPositiveButton("Sim", (dialog, which) -> clearFields())
                .setNegativeButton("Não", null)
                .show();
    }

    private void clearFields() {
        nameInput.setText("");
        lastNameInput.setText("");
        cpfInput.setText("");
        phoneInput.setText("");
        emailInput.setText("");
        birthDatePicker.updateDate(2000, 0, 1);
        genderGroup.clearCheck();
        preferencesSpinner.setSelection(0);
    }

    private void validateAndRegister() {
        if (validateFields()) {
            showRegisterConfirmationDialog();
        }
    }

    private boolean validateFields() {
        boolean isValid = true;

        if (TextUtils.isEmpty(nameInput.getText())) {
            nameInput.setError("Campo obrigatório");
            isValid = false;
        }

        if (TextUtils.isEmpty(lastNameInput.getText())) {
            lastNameInput.setError("Campo obrigatório");
            isValid = false;
        }

        String cpf = cpfInput.getText().toString();
        if (cpf.length() < 11) { // Checking if CPF has all digits (including dots and dash)
            cpfInput.setError("CPF inválido");
            isValid = false;
        }

        String phone = phoneInput.getText().toString();
        if (phone.length() < 14) { // Checking if phone has all digits (including parentheses and dash)
            phoneInput.setError("Telefone inválido");
            isValid = false;
        }

        if (TextUtils.isEmpty(emailInput.getText())) {
            emailInput.setError("Campo obrigatório");
            isValid = false;
        }

        if (genderGroup.getCheckedRadioButtonId() == -1) {
            isValid = false;
        }

        return isValid;
    }

    private void showRegisterConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmar cadastro")
                .setMessage("Deseja confirmar o cadastro?")
                .setPositiveButton("Sim", (dialog, which) -> finishRegistration())
                .setNegativeButton("Não", null)
                .show();
    }

    private void finishRegistration() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
