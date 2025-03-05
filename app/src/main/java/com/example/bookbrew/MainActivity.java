package com.example.bookbrew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.widget.EditText;
import android.widget.Button;
import android.view.ViewGroup;

import com.example.bookbrew.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.editTextUsername.getText().toString();
                String password = binding.editTextPassword.getText().toString();

                if (username.equals("user") && password.equals("password")) {
                    Intent intent = new Intent(MainActivity.this, BooksActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Credenciais inválidas!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showForgotPasswordDialog();
            }
        });

        binding.textViewRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showForgotPasswordDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_forgot_password);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        EditText emailInput = dialog.findViewById(R.id.emailInputDialog);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);
        Button sendButton = dialog.findViewById(R.id.sendButton);

        cancelButton.setOnClickListener(v -> dialog.dismiss());

        sendButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            // Me ajude a implementar aqui a exibir uma senha temporária no Toast
            Toast.makeText(MainActivity.this, "Senha temporária enviada para " + email, Toast.LENGTH_SHORT).show();


            dialog.dismiss();
        });

        dialog.show();
    }
}
