//package com.example.andy.footmark;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.widget.RelativeLayout;
//
///**
// * Created by andy on 7/23/16.
// * 自定义布局，正方形显示图片
// */
//public class SquareLayout extends RelativeLayout {
//
//    public SquareLayout(Context context, AttributeSet atts, int defStyle) {
//        super(context, atts, defStyle);
//    }
//
//    public SquareLayout(Context context, AttributeSet atts) {
//        super(context, atts);
//    }
//
//    public SquareLayout(Context context) {
//        super(context);
//    }
//
//    @SuppressWarnings("unused")
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        // For simple implementation, or internal size is always 0.
//        // We depend on the container to specify the layout size of
//        // our view. We can't really know what it is since we will be
//        // adding and removing different arbitrary views and do not
//        // want the layout to change as this happens.
//        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
//
//        //Children are just make to fill our space.
//        int childWidthSize = getMeasuredWidth();
//        int childHeightSize = getMeasuredHeight();
////        <span style="color: rgb(153, 153, 153); font-family: Monaco, MonacoRegular, 'Courier New', monospace;  line-height: 15px; white-space: pre; background-color: rgb(248, 248, 255);"><em>//高度和宽度一样</em></span>
//        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }
//
//}
