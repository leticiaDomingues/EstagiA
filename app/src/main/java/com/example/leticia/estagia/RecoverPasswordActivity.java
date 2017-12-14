package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RecoverPasswordActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        //set up a click listener for the sendRequest button.
        findViewById(R.id.btnRecoverPassword).setOnClickListener(this);
    }

    public void onClick(View v) {
        final Context context = getApplicationContext();

        String ra = ((EditText)findViewById(R.id.txtRaCpf)).getText().toString();

        if(!ra.equals("")) {
            User user = MyDB.getUser(ra);
            if(user!=null) {
                Toast.makeText(context, "As instruções foram enviadas para o email " + user.getEmail(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(context, "RA não existente na base de dados.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Informe o RA.", Toast.LENGTH_SHORT).show();
        }
    }
}
