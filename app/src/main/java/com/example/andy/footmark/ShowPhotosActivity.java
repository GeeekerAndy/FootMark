package com.example.andy.footmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

public class ShowPhotosActivity extends AppCompatActivity {
    private GridView showPhotos;
    private ImageView onePhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photos);
        showPhotos = (GridView)findViewById(R.id.gv_show_photos);
        onePhotos = (ImageView)findViewById(R.id.iv_one_photo);
        for(int i = 0;  i < 20; i++) {

        }
    }
}
