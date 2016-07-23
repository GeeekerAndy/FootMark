package com.example.andy.footmark;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by andy on 7/23/16.
 * 图片适配器，向GridView中添加图片
 */
public class ImageAdapter extends BaseAdapter {

    Integer[] imageIDs = {
//            R.drawable.bkg_01_january,
//            R.drawable.bkg_02_february,
//            R.drawable.bkg_03_march,
//            R.drawable.bkg_04_april,
//            R.drawable.bkg_05_may,
//            R.drawable.bkg_06_june,
//            R.drawable.bkg_07_july,
//            R.drawable.bkg_08_august,
//            R.drawable.bkg_09_september,
//            R.drawable.bkg_10_october,
//            R.drawable.bkg_11_november,
//            R.drawable.bkg_12_december
            R.drawable.bkg_01_january_vertical,
            R.drawable.bkg_03_march_vertical,
            R.drawable.bkg_01_january_vertical,
            R.drawable.bkg_03_march_vertical,
            R.drawable.bkg_01_january_vertical,
            R.drawable.bkg_03_march_vertical,
            R.drawable.bkg_01_january_vertical,
            R.drawable.bkg_03_march_vertical,
            R.drawable.bkg_01_january_vertical,
            R.drawable.bkg_03_march_vertical,
            R.drawable.bkg_01_january_vertical,

    };

    private Context context;
    private WindowManager windowManager;
    private Display display;

    public ImageAdapter(Context context) {
        windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        this.context = context;
    }

    /**
     * 返回图片数量
     * @return
     */
    public int getCount() {
        return imageIDs.length;
    }

    /**
     * 返回一个item的ID
     */
    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(display.getWidth()/2, display.getWidth()/2 ));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(imageIDs[position]);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        return imageView;
    }
}
