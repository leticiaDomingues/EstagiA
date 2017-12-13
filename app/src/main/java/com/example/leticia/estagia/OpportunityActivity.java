package com.example.leticia.estagia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OpportunityActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity);

        Intent i = this.getIntent();
        String src = i.getStringExtra("imgSrc");
        String body = i.getStringExtra("txtBody");
        String title = i.getStringExtra("txtTitle");

        int imageResource = getResources().getIdentifier(src, null, getPackageName());
        ImageView imgView = findViewById(R.id.imgView);
        imgView.setImageResource(imageResource);

        TextView txtBody = findViewById(R.id.txtBody);
        txtBody.setText(this.getResources().getIdentifier(body,null,getPackageName()));
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(title);
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

    }
}
