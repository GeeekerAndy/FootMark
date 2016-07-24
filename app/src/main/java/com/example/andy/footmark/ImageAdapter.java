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

    /**
     * 获取每张图片的id
     * @param position
     * @return
     */
    public Integer getImageId(int position) {
        return imageIDs[position];
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
        return imageView;
    }
}
