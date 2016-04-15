package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;

public class DynamicHeightNetworkImageView extends NetworkImageView {
    private float mAspectRatio = 2/3f;

    public DynamicHeightNetworkImageView(Context context) {
        super(context);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("onMeasure","Ratio: "+mAspectRatio);
        Log.d("onMeasure","width: : "+MeasureSpec.getSize(widthMeasureSpec));
        float threeTwoHeight=  ((float)MeasureSpec.getSize(widthMeasureSpec));
        Log.d("onMeasure","threeTwoHeight: : "+threeTwoHeight);
        //1:1 now
//        float threeTwoHeight=  (MeasureSpec.getSize(widthMeasureSpec));
        int threeTwoHeightSpec = MeasureSpec.makeMeasureSpec((int) threeTwoHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, threeTwoHeightSpec);
       /* int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (int) (measuredWidth / mAspectRatio));*/
    }
}
