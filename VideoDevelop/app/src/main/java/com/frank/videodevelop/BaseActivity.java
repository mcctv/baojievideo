package com.frank.videodevelop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.frank.videodevelop.util.StatusBarUtil;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.main_color), 0);  // 设置状态栏颜色

    }
}
