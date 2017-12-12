package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

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

    }
}
