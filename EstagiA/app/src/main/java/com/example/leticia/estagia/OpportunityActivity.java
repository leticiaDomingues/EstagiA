package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.net.Uri;
import android.content.ActivityNotFoundException;
import android.text.Html;

public class OpportunityActivity extends Activity implements View.OnClickListener {
    Opportunity opportunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity);

        findViewById(R.id.btnCadastrar).setOnClickListener(this);

        //get opportunity
        Bundle extras = getIntent().getExtras();
        opportunity = MyDB.getOpportunity(extras.getString("empresa"));

        //display info
        TextView txtName = findViewById(R.id.txtNome);
        txtName.setText(opportunity.getEmpresa());
        TextView txtLocal = findViewById(R.id.txtLocal);
        txtLocal.setText(Html.fromHtml("<b>Local:</b> " + opportunity.getLocal()));
        TextView txtData = findViewById(R.id.txtData);
        txtData.setText(Html.fromHtml("<b>Inscrições até: </b> " + opportunity.getData()));
        TextView txtDescricao = findViewById(R.id.txtDescricao);
        txtDescricao.setText(opportunity.getDescricao());
        ImageView imgLogo = findViewById(R.id.imgLogo);
        int id = getResources().getIdentifier("com.example.leticia.estagia:drawable/" + opportunity.getLogo(), null, null);
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
        final Context context = getApplicationContext();

        if(v.getId() == R.id.btnCadastrar) {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(opportunity.getSite()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.chrome");
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                context.startActivity(intent);
            }
        }
    }
}
