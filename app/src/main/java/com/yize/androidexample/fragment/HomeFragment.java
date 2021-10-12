package com.yize.androidexample.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.yize.androidexample.R;
import com.yize.tools.base.BaseFragment;

/**
 * @Description: 起始页
 * @Author: YiZe
 * @Date: 2021年10月09日   星期六   17:12
 */
public class HomeFragment extends BaseFragment {
    private HomeViewModel mHomeViewModel;

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
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        //延时更新数据
        mHomeViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), testModels -> {
            //此处写要更新内容的控件信息
        });
    }
}