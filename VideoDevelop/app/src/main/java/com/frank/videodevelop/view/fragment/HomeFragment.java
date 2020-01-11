package com.frank.videodevelop.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.frank.videodevelop.R;
import com.frank.videodevelop.adapter.HomePagerAdapter;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/*
 * HomeFragment  2019-12-23
 * Copyright (c) 2019 KL Co.Ltd. All right reserved.
 *
 */
/*
 * class description here
 * @author Jackson
 * @version 1.0.0
 * since 2019 12 23
 */
public class HomeFragment extends Fragment {

    private View view;
    private ViewPager mViewPager;          // ViewPager
    private TabLayout mHomeTabLayout;    // TabLayout


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, null);
            initView(view);
            initViewPager();

        }

        return view;
    }

    /**
     * 初始化控件
     */
    private void initView(View view){
        mViewPager = view.findViewById(R.id.homeViewPager);
        mHomeTabLayout = view.findViewById(R.id.homeTab);
    }


    /**
     * 初始化并设置ViewPager
     */
    private void initViewPager() {

        List<String> titles = new ArrayList<>();
        titles.add("消息");
        titles.add("通话");
        titles.add("朋友");

        for (int i = 0; i < titles.size(); i++) {
            mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();

        // 添加Fragment
        MessageFragment messageFragment = MessageFragment.newInstance();
        CommunicateFragment communicateFragment = CommunicateFragment.newInstance();
        FriendFragment friendFragment = FriendFragment.newInstance();
        fragments.add(messageFragment);
        fragments.add(communicateFragment);
        fragments.add(friendFragment);

        //给ViewPager设置适配器
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(Objects.requireNonNull(this.getActivity()).getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(homePagerAdapter);
        //将TabLayout和ViewPager关联起来
        mHomeTabLayout.setupWithViewPager(mViewPager);
        mHomeTabLayout.setTabMode(TabLayout.MODE_FIXED);

    }





    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }




}