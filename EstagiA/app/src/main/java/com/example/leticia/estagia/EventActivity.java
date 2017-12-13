package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        findViewById(R.id.btnCadastrar).setOnClickListener(this);

        //get event
        Bundle extras = getIntent().getExtras();
        Event event = MyDB.getEvent(extras.getString("empresa"));

        //display info
        TextView txtName = findViewById(R.id.txtNome);
        txtName.setText(event.getEmpresa());
        TextView txtLocal = findViewById(R.id.txtLocal);
        txtLocal.setText(Html.fromHtml("<b>Local:</b> " + event.getLocal()));
        TextView txtData = findViewById(R.id.txtData);
        txtData.setText(Html.fromHtml("<b>Inscrições até: </b> " + event.getData()));
        TextView txtDescricao = findViewById(R.id.txtDescricao);
        txtDescricao.setText(event.getDescricao());
        ImageView imgLogo = findViewById(R.id.imgLogo);
        int id = getResources().getIdentifier("com.example.leticia.estagia:drawable/" + event.getLogo(), null, null);
        imgLogo.setImageResource(id);
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
