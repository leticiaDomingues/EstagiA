package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


public class SignUpActivity extends Activity implements View.OnClickListener {

    String curso = "BCC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        //set up a click listener for the sendRequest button.
        View btnSendRequest = findViewById(R.id.btnSendRequest);
        btnSendRequest.setOnClickListener(this);
    }

    public void onClick(View v) {
        final Context context = getApplicationContext();

        String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
        String ra = ((EditText)findViewById(R.id.txtRa)).getText().toString();
        String email = ((EditText)findViewById(R.id.txtEmail)).getText().toString();
        String senha = ((EditText)findViewById(R.id.txtSenha)).getText().toString();
        String confirmacaoSenha = ((EditText)findViewById(R.id.txtConfirmacaoSenha)).getText().toString();

        if(!nome.equals("") && !ra.equals("") && !email.equals("") && !senha.equals("") && !confirmacaoSenha.equals("")) {
            Intent i = new Intent(this, SignUpActivity.class);

            Bundle extraInfo = new Bundle();
            extraInfo.putString("nome", nome);
            extraInfo.putString("ra", ra);
            extraInfo.putString("email", email);
            extraInfo.putString("senha", senha);
            extraInfo.putString("curso", curso);
            i.putExtras(extraInfo);

            startActivity(i);
        }

        //display the main activity
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void onRadioButtonClicked(View view) {
        //check if the button is currently checked
        boolean checked = ((RadioButton) view).isChecked();

        //check which radio is checked
        switch(view.getId()) {
            case R.id.radio_bcc:
                if (checked)
                    curso = "BCC";
                    break;
            case R.id.radio_enc:
                if (checked)
                    curso = "EnC";
                    break;
        }
    }

}
