package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;

public class profileActivity extends AppCompatActivity {

    private ImageView selectedImage;

//    private ImageView lastOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        lastOne = findViewById(R.id.ic_logo_00);
    }

    public void setTeamIconView(View view){
        Intent returnIntent = new Intent();

        selectedImage = (ImageView) view;

        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            if (extras.containsKey("data")) {
//                Bitmap bmp = (Bitmap) extras.get("data");
//                File sd = Environment.getExternalStorageDirectory();
//                File image = new File(sd+filePath, imageName);
//                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//                Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
//                bitmap = Bitmap.createScaledBitmap(bitmap,parent.getWidth(),parent.getHeight(),true);
//                lastOne.setImageBitmap(bitmap);
//            } else {
//                Toast.makeText(getBaseContext(), "Fail to capture Image", Toast.LENGTH_LONG).show();
//            }
//        }
//    }


//    public void onClickCamera(View view){
//        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(i, 100);
//    }
}