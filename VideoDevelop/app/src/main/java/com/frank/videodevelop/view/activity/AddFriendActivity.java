package com.frank.videodevelop.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.frank.videodevelop.BaseActivity;
import com.frank.videodevelop.R;


public class AddFriendActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llBack;  // 返回
    private TextView tvTitle;     // 标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        initView();
    }

    /**
     * 初始化界面
     * 设置监听
     */
    private void initView(){
        llBack=findViewById(R.id.ll_back);
        tvTitle=findViewById(R.id.tv_head_title);

        llBack.setOnClickListener(this);
        tvTitle.setText("邀请朋友");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_back:   // 返回
                finish();     // 关闭页面
                break;
        }
    }
}
