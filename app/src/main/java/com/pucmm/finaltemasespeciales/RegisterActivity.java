package com.pucmm.finaltemasespeciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pucmm.finaltemasespeciales.database.AppDatabase;
import com.pucmm.finaltemasespeciales.database.dao.UserDAO;
import com.pucmm.finaltemasespeciales.database.entity.User;
import com.pucmm.finaltemasespeciales.repository.UserRepository;
import com.pucmm.finaltemasespeciales.repository.UserRepositoryImpl;

public class RegisterActivity extends AppCompatActivity {

    Button registerButton;
    EditText nombreEdit;
    EditText usuarioEdit;
    EditText correoEdit;
    EditText contraseniaEdit;
    EditText repeatContraseniaEdit;
    EditText telefonoEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nombreEdit = findViewById(R.id.correoLoginText);
        usuarioEdit = findViewById(R.id.usuarioText);
        correoEdit = findViewById(R.id.correoText);
        contraseniaEdit = findViewById(R.id.passwordText);
        repeatContraseniaEdit = findViewById(R.id.repeatContraseñaText);
        telefonoEdit = findViewById(R.id.telefonoText);
        registerButton = findViewById(R.id.registerButton);


        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        UserDAO dao = db.userDAO();
        UserRepository repo = new UserRepositoryImpl(dao);


        registerButton.setOnClickListener(v -> {

            User usuario = new User();

            if (validacionCorreo()) {
                if (validacionContraseia(contraseniaEdit, repeatContraseniaEdit)) {
                    usuario.setNombre(nombreEdit.getText().toString());
                    usuario.setUsuario(usuarioEdit.getText().toString().toLowerCase());
                    usuario.setCorreo(correoEdit.getText().toString().toLowerCase());
                    usuario.setContrasenia(contraseniaEdit.getText().toString());
                    usuario.setTelefono(telefonoEdit.getText().toString());

                    repo.insertUser(usuario);
                    Toast.makeText(RegisterActivity.this, "Usuario creado exitosamente, ahora inicie sesión", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Contraseñas deben ser iguales.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "El correo electrónico es incorrecto", Toast.LENGTH_LONG).show();
            }


        });


    }

    private boolean validacionContraseia(EditText contrasenia, EditText repetirContrasenia) {
        if (contrasenia.getText().toString().equals(repetirContrasenia.getText().toString())) {
            return true;
        } else {
            contraseniaEdit.setError("Contraseñas deben ser iguales");
            repeatContraseniaEdit.setError("Contraseñas deben ser iguales");
            return false;
        }
    }

    private boolean validacionCorreo() {
        String correo = correoEdit.getText().toString().trim();
        if (correo.isEmpty() || !correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$")) {
            correoEdit.setError("Debe proveer un email valido");
            return false;
        } else {
            return true;
        }
    }


}