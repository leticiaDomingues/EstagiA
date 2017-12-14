package com.example.leticia.estagia;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MyProfileActivity extends Activity implements View.OnClickListener {
    final int MyVersion = Build.VERSION.SDK_INT;
    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_PICK);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);;

                } else {
                    Toast.makeText(this.getApplicationContext(), "Please give your permission.", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        if (MyDB.ra.equals("")) {
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
            RadioButton radioBcc = (RadioButton) findViewById(R.id.radio_bcc);
            RadioButton radioEnc = (RadioButton) findViewById(R.id.radio_enc);
            if (user.getCurso().equals("BCC")) {
                radioBcc.setChecked(true);
            } else {
                radioEnc.setChecked(true);
            }

        }

        (findViewById(R.id.Galeria)).setOnClickListener(this);

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

    public void onClick(View v) {
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                String[] strings = {Manifest.permission.READ_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(this, strings, 1);
            } else {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                ImageView imageView = findViewById(R.id.imgPerfil);
                //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath,options));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        //if the user is not logged in
        if (MyDB.ra.equals("")) {
            //display the main activity
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}


