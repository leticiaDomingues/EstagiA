package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up a click listener for the login button.
        View btnRegister = findViewById(R.id.btnLogin);
        btnRegister.setOnClickListener(this);
    }

    public void onClick(View v) {
        final Context context = getApplicationContext();

        if(v.getId() == R.id.btnLogin) {
            //display the login activity
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }
}
