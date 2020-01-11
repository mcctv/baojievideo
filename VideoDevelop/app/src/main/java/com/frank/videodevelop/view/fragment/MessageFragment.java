package com.frank.videodevelop.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.frank.videodevelop.R;
import com.frank.videodevelop.view.activity.AddFriendActivity;


/*
 * MessageFragment  2019-12-23
 * Copyright (c) 2019 KL Co.Ltd. All right reserved.
 *
 */
/*
 * class description here
 * @author Jackson
 * @version 1.0.0
 * since 2019 12 23
 */
public class MessageFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btnJump;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_message, null);

            btnJump=view.findViewById(R.id.btnJump);
            btnJump.setOnClickListener(this);    // 监听事件

        }

        return view;
    }


    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * 所有的监听事件写在此处
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnJump:
                Intent intent=new Intent(this.getActivity(), AddFriendActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}