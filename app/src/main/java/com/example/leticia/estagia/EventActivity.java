package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class EventActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent i = this.getIntent();
        String src = i.getStringExtra("imgSrc");
        String body = i.getStringExtra("txtBody");
        String date = i.getStringExtra("eventDate");
        String title = i.getStringExtra("txtTitle");

        int imageResource = getResources().getIdentifier(src, null, getPackageName());
        ImageView imgView = findViewById(R.id.imgEvent);
        imgView.setImageResource(imageResource);
        TextView eventBody = findViewById(R.id.eventBody);
        eventBody.setText(this.getResources().getIdentifier(body,null,getPackageName()));
        TextView eventDate = findViewById(R.id.eventDate);
        eventDate.setText(date);
        TextView eventTitle = findViewById(R.id.eventTitle);
        eventTitle.setText(title);

        findViewById(R.id.btnCadastrar).setOnClickListener(this);

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
        TextView eventDate = findViewById(R.id.eventDate);
        String aux = eventDate.getText().toString();
        String[] aux1 = aux.split("/");
        Calendar beginCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        beginCal.set(Integer.parseInt(aux1[2]),Integer.parseInt(aux1[1])-1,Integer.parseInt(aux1[0]),8,00);
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginCal.getTimeInMillis());
        //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endCal.getTimeInMillis());
        //intent.putExtra("allDay", true);
        //intent.putExtra("rrule", "FREQ=YEARLY");
        TextView eventTitle = findViewById(R.id.eventTitle);
        intent.putExtra("title", "Evento "+eventTitle.getText().toString());
        startActivity(intent);
    }
}
