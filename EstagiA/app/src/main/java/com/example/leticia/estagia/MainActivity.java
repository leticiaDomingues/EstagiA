package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

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
    }

    public void onClick(View v) {
        final Context context = getApplicationContext();

        if(v.getId() == R.id.btnLogin) {
            String login = ((EditText)findViewById(R.id.txtRaCpf)).getText().toString();
            String senha = ((EditText)findViewById(R.id.txtSenha)).getText().toString();

            Intent i = new Intent(this, DashboardActivity.class);

            if(!login.equals("") && !senha.equals("")) {
                Bundle extraInfo = new Bundle();
                extraInfo.putString("login", login);
                extraInfo.putString("senha", senha);
                i.putExtras(extraInfo);
            }

            startActivity(i);
        } else if(v.getId() == R.id.btnCadastrar) {
            //display the signup activity
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        } else if(v.getId() == R.id.txtRecoverPassword) {
            //display the signup activity
            Intent i = new Intent(this, RecoverPasswordActivity.class);
            startActivity(i);
        }
    }
}
