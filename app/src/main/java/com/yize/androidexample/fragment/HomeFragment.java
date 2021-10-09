package com.yize.androidexample.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yize.androidexample.R;
import com.yize.tools.base.BaseFragment;
import com.yize.tools.base.BaseViewModel;

import org.w3c.dom.Text;

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
        TextView textView = view.findViewById(R.id.tv_title);
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        //延时更新数据
        mHomeViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), testModels -> {
            //此处写要更新内容的控件信息
            textView.setText(testModels);
        });
    }
}