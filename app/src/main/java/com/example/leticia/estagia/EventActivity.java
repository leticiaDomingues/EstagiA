package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

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
        Bundle extras = getIntent().getExtras();
        Event event = MyDB.getEvent(extras.getString("empresa"));
        String aux = event.getData();
        String[] aux1 = aux.split("/");
        Calendar beginCal = Calendar.getInstance();
        //Calendar endCal = Calendar.getInstance();
        beginCal.set(Integer.parseInt(aux1[2]),Integer.parseInt(aux1[1])-1,Integer.parseInt(aux1[0]),8,00);
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginCal.getTimeInMillis());
        //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endCal.getTimeInMillis());
        //intent.putExtra("allDay", true);
        //intent.putExtra("rrule", "FREQ=YEARLY");
        TextView eventTitle = findViewById(R.id.txtNome);
        intent.putExtra("title", "Evento "+eventTitle.getText().toString());
        startActivity(intent);
    }
}
