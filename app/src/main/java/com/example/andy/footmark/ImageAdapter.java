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
            "http://tse1.mm.bing.net/th?id=OIP.M0eeedbbb12636ff83c538dc9575e3a65o0&w=202&h=151&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse1.mm.bing.net/th?&id=OIP.M76e609bf7fdcd7faed7db89581f6cb45o0&w=299&h=200&c=0&pid=1.9&rs=0&p=0",
            "http://tse1.mm.bing.net/th?&id=OIP.M23d172cd98029790fb6f16ec65d4de3eo0&w=299&h=200&c=0&pid=1.9&rs=0&p=0",
            "http://tse3.mm.bing.net/th?id=OIP.M63319cee4cd5ef08c5ab64a03b792573o0&w=199&h=117&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse2.mm.bing.net/th?id=OIP.M9c34085316980c87fe11308300f0dcbdo0&w=189&h=135&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse1.mm.bing.net/th?&id=OIP.Mdf84cc41a8c0ee834934bab9896079a5H0&w=300&h=225&c=0&pid=1.9&rs=0&p=0",
            "http://tse1.mm.bing.net/th?id=OIP.M9289b925cc73a11f33bc921cc0d4c549H0&w=190&h=140&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse1.mm.bing.net/th?&id=OIP.Me7d829199ad1168c21000d9d79771a85H0&w=300&h=200&c=0&pid=1.9&rs=0&p=0",
            "http://cn.bing.com/s/loading_lg_w.gif",
            "http://tse1.mm.bing.net/th?id=OIP.Md616772af62898c888e81bc78c152dbbH0&w=228&h=154&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://cn.bing.com/s/loading_lg_w.gif",
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
