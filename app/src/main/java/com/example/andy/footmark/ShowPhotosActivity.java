package com.example.andy.footmark;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by andy on 7/22/16.
 * 展示一个活动图片的Activity
 */
public class ShowPhotosActivity extends AppCompatActivity {

    private GridView gridView;
    private ImageAdapter imageAdapter;
    private Dialog dialog;
    private ImageView onePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photos);

        //自定义Toolbar
        Toolbar showPhotoToolBar = (Toolbar)findViewById(R.id.tb_show_photos);
        setSupportActionBar(showPhotoToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        showPhotoToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imageAdapter = new ImageAdapter(this);
        gridView = (GridView)findViewById(R.id.gv_show_photos);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //完整显示GridView中的图片
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                dialog = new Dialog(ShowPhotosActivity.this, android.R.style.Theme_NoTitleBar_Fullscreen);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.show_one_picture);
                onePicture = (ImageView)dialog.findViewById(R.id.iv_preview_image);
                onePicture.setImageResource(imageAdapter.getImageId(position));
                onePicture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

}
