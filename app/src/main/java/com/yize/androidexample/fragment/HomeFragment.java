package com.yize.androidexample.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.yize.androidexample.R;
import com.yize.tools.base.BaseFragment;

/**
 * @Desc: 起始页
 * @Date: 2021年10月09日
 * @Time: 17:12
 * @Author: 李易泽
 */
public class HomeFragment extends BaseFragment {
    @NonNull
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int initViewRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initCreateView(View view) {
    }
}