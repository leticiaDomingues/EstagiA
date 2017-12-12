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

public class OpportunitiesActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities);

        //set up click listeners
        findViewById(R.id.google).setOnClickListener(this);
        findViewById(R.id.apple).setOnClickListener(this);
        findViewById(R.id.microsoft).setOnClickListener(this);
        findViewById(R.id.amazon).setOnClickListener(this);
        findViewById(R.id.lg).setOnClickListener(this);
        findViewById(R.id.dell).setOnClickListener(this);
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
        //if(v.getId() == R.id.google) {
            Intent i = new Intent(this, OpportunityActivity.class);
            startActivity(i);
        //}
    }
}