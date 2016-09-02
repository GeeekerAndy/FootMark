package com.example.andy.footmark;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by andy on 7/23/16.
 * Image adapter for adding images to GridView.
 * 图片适配器，向GridView中添加图片
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private WindowManager windowManager;
    private Display display;
    private Point size;
    private int screenWidth;
    private int screenHeight;

    String[] imageUrl = {
            "http://tse1.mm.bing.net/th?&id=OIP.M2d93668578a935c29c2c07a6b58afbc8o0&w=300&h=187&c=0&pid=1.9&rs=0&p=0&r=0",
            "http://tse1.mm.bing.net/th?&id=OIP.M05aa60307f00a7a9fe37ca07147c6716o0&w=299&h=187&c=0&pid=1.9&rs=0&p=0&r=0",
            "http://tse1.mm.bing.net/th?&id=OIP.M0dd8d2b4c3b691913db6e12e1626e6ffo0&w=300&h=187&c=0&pid=1.9&rs=0&p=0&r=0",
            "http://tse3.mm.bing.net/th?id=OIP.M19ea9835ca39a8fb7f3b679cad54b089o0&w=265&h=175&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse1.mm.bing.net/th?id=OIP.M5d7250d8469f8deb786a864e008a11fao0&w=264&h=171&c=7&rs=1&qlt=90&o=4&pid=1.1",
 };


    public ImageAdapter(Context context) {
        windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        this.context = context;
        size = new Point();
        windowManager.getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    /**
     * Return the count of images.
     * 返回图片数量
     * @return
     */
    public int getCount() {
        return imageUrl.length;
    }

    /**
     * Return an ID of the item
     * 返回一个item的ID
     */
    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /**
     * Get the ID of every image.
     * 获取每张图片的id
     * @param position
     * @return
     */
//    public Integer getImageId(int position) {
//        return imageUrl[position];
//    }

    public String getImageUrl(int position) {
        return imageUrl[position];
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(screenWidth/2, screenWidth/2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView)convertView;
        }
//        imageView.setImageResource(imageIDs[position]);

        //调用Glide库加载图片
        Glide.with(context)
                .load(imageUrl[position])
                .crossFade()
                .into(imageView);


        return imageView;
    }
}
