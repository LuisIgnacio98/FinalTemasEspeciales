package com.pucmm.finaltemasespeciales;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pucmm.finaltemasespeciales.database.AppDatabase;
import com.pucmm.finaltemasespeciales.database.dao.UserDAO;
import com.pucmm.finaltemasespeciales.database.entity.User;
import com.pucmm.finaltemasespeciales.repository.UserRepository;
import com.pucmm.finaltemasespeciales.repository.UserRepositoryImpl;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    TextView registerText;
    TextView olvidoContraseña;
    EditText correoText;
    EditText contraseñaText;
    ProgressBar loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        UserDAO dao = db.userDAO();
        UserRepository repo = new UserRepositoryImpl(dao);


        correoText = findViewById(R.id.correoLoginText);
        contraseñaText = findViewById(R.id.contraseniaText);
        loginButton = findViewById(R.id.registerButton);
        registerText = findViewById(R.id.registerText);
        olvidoContraseña = findViewById(R.id.olvidoContraseniaText);
        loading = findViewById(R.id.progressBar);

        loginButton.setOnClickListener(v -> {
            loading.setVisibility(View.VISIBLE);

            String correo = correoText.getText().toString().trim();
            String contraseña = contraseñaText.getText().toString().trim();


            if (validacionCorreo(correo, contraseña)) {
                User usuario = repo.getUserLogin(correo, contraseña);
                if (usuario != null) {
                    Toast.makeText(LoginActivity.this, "Inicio de sesión correcto", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    loading.setVisibility(View.INVISIBLE);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
                    alertDialogBuilder.setTitle("Inicio de sesión fallido");
                    alertDialogBuilder.setMessage("Correo y/o contraseña incorrectos");
                    alertDialogBuilder.show();
                }
            } else {
                loading.setVisibility(View.INVISIBLE);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

                alertDialogBuilder.setMessage("Correo y/o contraseña inválidos");
                alertDialogBuilder.show();
            }
        });

        registerText.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), RegisterActivity.class);
            startActivity(i);
        });

        olvidoContraseña.setOnClickListener(v ->{
            Intent i = new Intent(v.getContext(), ForgotPasswordActivity.class);
            startActivity(i);
        });
    }

    private boolean validacionCorreo(String correo, String contraseña) {
        if (correo.isEmpty() || !correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$")) {
            correoText.setError("Debe proveer un email válido");
            return false;
        } else if (contraseña.isEmpty()) {
            contraseñaText.setError("Debe ecribir una contraseña.");
            return false;
        } else {
            return true;
        }
    }
}
