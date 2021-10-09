package com.yize.androidexample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yize.androidexample.R;

/**
 * @Description: 测试Fragment
 * @Author: YiZe
 * @Date: 2021年10月08日   星期五   11:10
 */
public class Test2Fragment extends Fragment {

    private TestViewModel mTestViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取ViewModel
        mTestViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_test2, container, false);
        //延时更新数据
        mTestViewModel.getTestData().observe(getViewLifecycleOwner(), testModels -> {
            //此处写要更新内容的控件信息
        });
        return root;
    }
}
