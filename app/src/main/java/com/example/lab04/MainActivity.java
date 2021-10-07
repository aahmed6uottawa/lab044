package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnGmap;
    private EditText teamAddress;
    private EditText teamName;
    private ImageView avatarImage;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGmap = findViewById(R.id.btnGmap);
        teamAddress = findViewById(R.id.teamAddress);
        teamName = findViewById(R.id.teamName);
        avatarImage = findViewById(R.id.avatarID);
    }

    public void onOpeningGoogleMaps(View view){
       Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        super.onActivityResult(requestCode, resultCode, data);
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.ic_logo_00)){
            case R.id.ic_logo_00:
                drawableName = "ic_logo_00";
                break;
            case R.id.ic_logo_01:
                drawableName = "ic_logo_01";
            case R.id.ic_logo_02:
                drawableName = "ic_logo_02";
                break;
            case R.id.ic_logo_03:
                drawableName = "ic_logo_03";
                break;
            case R.id.ic_logo_04:
                drawableName = "ic_logo_04";
                break;
            case R.id.ic_logo_05:
                drawableName = "ic_logo_05";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);

        }


    public void onSetAvatarButton(View view){
        Intent intent = new Intent(this, profileActivity.class);
        startActivityForResult(intent, 0);
    }
}