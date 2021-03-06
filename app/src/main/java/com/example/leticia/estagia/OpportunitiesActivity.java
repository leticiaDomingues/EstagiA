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
        findViewById(R.id.daitan).setOnClickListener(this);
        findViewById(R.id.raccoon).setOnClickListener(this);
        findViewById(R.id.microsoft).setOnClickListener(this);
        findViewById(R.id.cpqd).setOnClickListener(this);
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
        if(v.getId() == R.id.google) {
            Intent i = new Intent(this, OpportunityActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Google");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.apple) {
            Intent i = new Intent(this, OpportunityActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Apple");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.daitan) {
            Intent i = new Intent(this, OpportunityActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Daitan");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.raccoon) {
            Intent i = new Intent(this, OpportunityActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Raccoon");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.microsoft) {
            Intent i = new Intent(this, OpportunityActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "Microsoft");
            i.putExtras(extraInfo);
            startActivity(i);
        } else if(v.getId() == R.id.cpqd) {
            Intent i = new Intent(this, OpportunityActivity.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("empresa", "CPqD");
            i.putExtras(extraInfo);
            startActivity(i);
        }
    }
}
