package com.frank.videodevelop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.frank.videodevelop.adapter.MainPagerAdapter;
import com.frank.videodevelop.util.StatusBarUtil;
import com.frank.videodevelop.view.fragment.FindFragment;
import com.frank.videodevelop.view.fragment.HomeFragment;
import com.frank.videodevelop.view.fragment.MineFragment;
import com.frank.videodevelop.view.fragment.RecommendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;          // ViewPager
    private TabLayout mBottomTabLayout;    // TabLayout


    private int[] mIcons = new int[]{R.drawable.selector_home, R.drawable.selector_find, R.drawable.selector_recommend, R.drawable.selector_mine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStatusBar();
        initView();
        initViewPager();
    }


    /**
     * 初始化StatusBar
     */
    private void initStatusBar() {
        StatusBarUtil.setColor(MainActivity.this, 0xffffffff, 0);  // 重新设置状态栏颜色
        StatusBarUtil.onlySetLightMode(MainActivity.this);   // 设置浅色主题
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        mViewPager = findViewById(R.id.mainViewPager);
        mBottomTabLayout = findViewById(R.id.bottomTabLayout);
    }

    /**
     * 初始化并设置ViewPager
     */
    private void initViewPager() {

        List<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("发现");
        titles.add("推荐");
        titles.add("我的");


        for (int i = 0; i < titles.size(); i++) {
            mBottomTabLayout.addTab(mBottomTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();

        // 添加Fragment
        HomeFragment homeFragment = HomeFragment.newInstance();
        FindFragment findFragment = FindFragment.newInstance();
        RecommendFragment recommendFragment = RecommendFragment.newInstance();
        MineFragment mineFragment = MineFragment.newInstance();

        fragments.add(homeFragment);
        fragments.add(findFragment);
        fragments.add(recommendFragment);
        fragments.add(mineFragment);
        //给ViewPager设置适配器
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mainPagerAdapter);
        //将TabLayout和ViewPager关联起来
        mBottomTabLayout.setupWithViewPager(mViewPager);
        mBottomTabLayout.setTabMode(TabLayout.MODE_FIXED);

        //进行 Tab自定义布局的实例化和添加
        for (int i = 0; i < titles.size(); i++) {
            //实例化 Tab 布局
            View view = LayoutInflater.from(this).inflate(R.layout.item_tab_layout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.tabImageView);
            TextView textView = (TextView) view.findViewById(R.id.tabTextView);
            textView.setText(titles.get(i));
            imageView.setImageResource(mIcons[i]);

            //将实例化好的 Tab 布局设置给当前的 Tab即可
            Objects.requireNonNull(mBottomTabLayout.getTabAt(i)).setCustomView(view);
        }


    }
}
