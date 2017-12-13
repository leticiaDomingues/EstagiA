package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class EventsActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //set up click listeners
        findViewById(R.id.spotify).setOnClickListener(this);
        findViewById(R.id.itau).setOnClickListener(this);
        findViewById(R.id.raccoon).setOnClickListener(this);
        findViewById(R.id.monitora).setOnClickListener(this);
        findViewById(R.id.motorola).setOnClickListener(this);
        findViewById(R.id.ibm).setOnClickListener(this);
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
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        Intent i = new Intent(this, EventActivity.class);
        TextView aux;
        String date;
        switch (v.getId()){
            case R.id.motorola:
                i.putExtra("imgSrc","@drawable/logo_motorola");
                aux = findViewById(R.id.txtMotorolaDate);
                date = aux.getText().toString();
                i.putExtra("eventDate",date);
                i.putExtra("txtTitle","Motorola");
                i.putExtra("txtBody","@string/motorola_info");
                break;
            case R.id.spotify:
                i.putExtra("imgSrc", "@drawable/logo_spotify");
                aux = findViewById(R.id.txtSpotifyDate);
                date = aux.getText().toString();
                i.putExtra("eventDate",date);
                i.putExtra("txtTitle","Spotify");
                i.putExtra("txtBody","@string/spotify_event_info");
                break;
            case R.id.itau:
                i.putExtra("imgSrc", "@drawable/logo_itau");
                aux = findViewById(R.id.txtItauDate);
                date = aux.getText().toString();
                i.putExtra("eventDate",date);
                i.putExtra("txtTitle","Itau");
                i.putExtra("txtBody","@string/itau_info");
                break;
            case R.id.raccoon:
                i.putExtra("imgSrc", "@drawable/logo_raccoon");
                aux = findViewById(R.id.txtRaccoonDate);
                date = aux.getText().toString();
                i.putExtra("eventDate",date);
                i.putExtra("txtTitle","Raccoon");
                i.putExtra("txtBody","@string/raccoon_info");
                break;
            case R.id.monitora:
                i.putExtra("imgSrc", "@drawable/logo_monitora");
                aux = findViewById(R.id.txtMonitoraDate);
                date = aux.getText().toString();
                i.putExtra("eventDate",date);
                i.putExtra("txtTitle","Monitora");
                i.putExtra("txtBody","@string/monitora_info");
                break;
            case R.id.ibm:
                i.putExtra("imgSrc", "@drawable/logo_ibm");
                aux = findViewById(R.id.txtIbmDate);
                date = aux.getText().toString();
                i.putExtra("eventDate",date);
                i.putExtra("txtTitle","IBM");
                i.putExtra("txtBody","@string/ibm_info");
                break;
            default:
                i.putExtra("imgSrc","@drawable/logo_motorola");
                i.putExtra("txtTitle","Motorola");
                i.putExtra("txtBody","@string/motorola_info");
        }
        startActivity(i);

    }
}
