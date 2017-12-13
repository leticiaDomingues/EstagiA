package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


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
            if(senha.equals(confirmacaoSenha)) {
                if(MyDB.getUser(ra) == null) {
                    User user = new User(nome, ra, curso, email, senha, false);
                    MyDB.addUser(user);
                    MyDB.ra = ra;
                    startActivity(new Intent(this, DashboardActivity.class));
                } else {
                    Toast.makeText(context, "RA já existente na base de dados.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "A senha deve ser igual a confirmação de senha.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }
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
