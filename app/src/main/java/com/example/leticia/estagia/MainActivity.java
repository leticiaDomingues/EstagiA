package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private static boolean firstExecution = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up a click listener for the login button.
        View btnRegister = findViewById(R.id.btnLogin);
        btnRegister.setOnClickListener(this);

        //set up a click listener for the signup button.
        View btnSignUp = findViewById(R.id.btnCadastrar);
        btnSignUp.setOnClickListener(this);

        //set up a click listener for the signup button.
        View txtRecoverPassword = findViewById(R.id.txtRecoverPassword);
        txtRecoverPassword.setOnClickListener(this);

        // Create a database for the app
        MyDB.populateDB();
        MyDB.firstExecution = false;
    }

    @Override
    protected void onStart() {
        super.onStart();

        //if the user is already logged in
        if(MyDB.ra != "") {
            //display the dashboard activity
            Intent i = new Intent(this, DashboardActivity.class);
            startActivity(i);
        }
    }

    public void onClick(View v) {
        final Context context = getApplicationContext();

        if(v.getId() == R.id.btnLogin) {
            String login = ((EditText)findViewById(R.id.txtRaCpf)).getText().toString();
            String senha = ((EditText)findViewById(R.id.txtSenha)).getText().toString();

            if(!login.equals("") && !senha.equals("")) {
                User user = MyDB.getUser(login);
                if(user != null) {
                    if(user.getSenha().equals(senha)) {
                        MyDB.ra = login;

                        Intent i = new Intent(this, DashboardActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(context, "Senha incorreta.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "RA não presente na base de dados.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Informe o RA e a senha.", Toast.LENGTH_SHORT).show();
            }
        } else if(v.getId() == R.id.btnCadastrar) {
            //display the signup activity
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        } else if(v.getId() == R.id.txtRecoverPassword) {
            //display the recover password activity
            Intent i = new Intent(this, RecoverPasswordActivity.class);
            startActivity(i);
        }
    }
}
