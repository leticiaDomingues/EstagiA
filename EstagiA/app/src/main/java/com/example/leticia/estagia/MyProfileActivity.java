package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MyProfileActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        if(MyDB.ra.equals("")) {
            //display the main activity
            startActivity(new Intent(this, MainActivity.class));
        } else {
            User user = MyDB.getUser(MyDB.ra);

            //display user info
            EditText txtName = findViewById(R.id.txtNome);
            txtName.setText(user.getNome());
            EditText txtRA = findViewById(R.id.txtRa);
            txtRA.setText(user.getRA());
            EditText txtEmail = findViewById(R.id.txtEmail);
            txtEmail.setText(user.getEmail());
            EditText txtSenha = findViewById(R.id.txtSenha);
            txtSenha.setText(user.getSenha());
            RadioButton radioBcc = (RadioButton)findViewById(R.id.radio_bcc);
            RadioButton radioEnc = (RadioButton)findViewById(R.id.radio_enc);
            if(user.getCurso().equals("BCC")) {
                radioBcc.setChecked(true);
            } else {
                radioEnc.setChecked(true);
            }
        }

        //set up a click listener for the editProfile button.
        findViewById(R.id.btnEditarPerfil).setOnClickListener(this);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.myProfile:
                startActivity(new Intent(this, MyProfileActivity.class));
                return true;
            case R.id.opportunities:
                startActivity(new Intent(this, OpportunitiesActivity.class));
                return true;
            case R.id.events:
                startActivity(new Intent(this, EventsActivity.class));
                return true;
            case R.id.exit:
                MyDB.ra = "";
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        //if the user is not logged in
        if(MyDB.ra.equals("")) {
            //display the main activity
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void onClick(View v) {
        final Context context = getApplicationContext();

        if(v.getId() == R.id.btnEditarPerfil) {
            String ra = ((EditText)findViewById(R.id.txtRa)).getText().toString();
            String email = ((EditText)findViewById(R.id.txtEmail)).getText().toString();
            String senha = ((EditText)findViewById(R.id.txtSenha)).getText().toString();
            RadioGroup radioMajor = findViewById(R.id.radio_major);
            RadioButton radioButton = findViewById(radioMajor.getCheckedRadioButtonId());

            if(!email.equals("") && !senha.equals("")) {
                User user = MyDB.getUser(ra);
                if(user != null) {
                    user.setEmail(email);
                    user.setSenha(senha);
                    user.setCurso(radioButton.getText().toString());

                    Toast.makeText(context, "Dados salvos com sucesso.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, DashboardActivity.class));
                }
            } else {
                Toast.makeText(context, "O email e a senha não podem estar em branco.", Toast.LENGTH_SHORT).show();
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
