package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class EventsActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //set up click listeners
        findViewById(R.id.spotify).setOnClickListener(this);
        findViewById(R.id.itau).setOnClickListener(this);
        findViewById(R.id.monitora).setOnClickListener(this);
        findViewById(R.id.ibm).setOnClickListener(this);
        findViewById(R.id.motorola).setOnClickListener(this);
        findViewById(R.id.amazon).setOnClickListener(this);
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
        if(v.getId() == R.id.spotify) {
            Intent i = new Intent(this, EventActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Spotify");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.itau) {
            Intent i = new Intent(this, EventActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Itaú");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.monitora) {
            Intent i = new Intent(this, EventActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Monitora");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.ibm) {
            Intent i = new Intent(this, EventActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "IBM");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.amazon) {
            Intent i = new Intent(this, EventActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Amazon");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.motorola) {
            Intent i = new Intent(this, EventActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Motorola");
            i.putExtras(extraInfo);
            startActivity(i);
        }
    }
}
