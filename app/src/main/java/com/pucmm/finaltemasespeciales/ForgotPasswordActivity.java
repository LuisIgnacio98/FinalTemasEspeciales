package com.pucmm.finaltemasespeciales;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.pucmm.finaltemasespeciales.database.AppDatabase;
import com.pucmm.finaltemasespeciales.database.dao.UserDAO;
import com.pucmm.finaltemasespeciales.repository.UserRepository;
import com.pucmm.finaltemasespeciales.repository.UserRepositoryImpl;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText correoText;
    Button resetContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        correoText = findViewById(R.id.correo2Text);
        resetContraseña = findViewById(R.id.resetPasswordButton);


        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        UserDAO dao = db.userDAO();
        UserRepository repo = new UserRepositoryImpl(dao);


        resetContraseña.setOnClickListener(v ->{
            String correo = correoText.getText().toString().trim();
            if(validacionCorreo(correo)){
                String contraseña = repo.getPasswordByEmail(correo);
                AlertDialog.Builder forgotPasswordResponse = new AlertDialog.Builder(v.getContext());
                if (contraseña != null)
                    forgotPasswordResponse.setTitle("Contraseña de " + correo).setMessage(contraseña).show();
                else
                    forgotPasswordResponse.setTitle("No encontramos su usuario").setMessage("Asegurese que este correo sea el correcto para su cuenta.").show();
            }else{
                correoText.setError("Debe proveer un correo válido");
            }
        });

    }

    private boolean validacionCorreo(String correo) {
        if (correo.isEmpty() || !correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$")) {
            return false;
        } else {
            return true;
        }
    }
}