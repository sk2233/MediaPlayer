package com.sk.mediaplayer.viewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NetVideoPager extends BasePager {

    public NetVideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(context);
        textView.setText("网络视频页面");
        textView.setTextSize(36);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

}
