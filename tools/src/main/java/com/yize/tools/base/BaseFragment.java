package com.yize.tools.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/**
 * @Description: 公共Fragment类
 * @Author: YiZe
 * @Date: 2021年10月09日   星期六   16:17
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initViewRes(), container, false);
        initCreateView(view);
        return view;
    }

    /**
     * 配置页面布局
     *
     * @return 设置的页面布局
     */
    protected abstract int initViewRes();

    /**
     * 初始化页面
     *
     * @param view 设置的View
     */
    protected abstract void initCreateView(View view);
}
