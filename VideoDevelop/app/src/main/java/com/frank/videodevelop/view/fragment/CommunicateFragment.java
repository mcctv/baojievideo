package com.frank.videodevelop.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.frank.videodevelop.R;


/*
 * CommunicateFragment  2019-12-23
 * Copyright (c) 2019 KL Co.Ltd. All right reserved.
 *
 */
/*
 * class description here
 * @author Jackson
 * @version 1.0.0
 * since 2019 12 23
 */
public class CommunicateFragment extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_communicate, null);


        }

        return view;
    }


    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static CommunicateFragment newInstance() {
        CommunicateFragment fragment = new CommunicateFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



   
}