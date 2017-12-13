package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RecoverPasswordActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);



        //set up a click listener for the sendRequest button.
        View btnRecoverPassword = findViewById(R.id.btnRecoverPassword);
        btnRecoverPassword.setOnClickListener(this);
    }

    public void onClick(View v) {
        //display the main activity
        CharSequence text = "Sua senha foi enviada ao seu email de cadastro!";
        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
