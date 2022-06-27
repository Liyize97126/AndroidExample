package com.yize.androidexample.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yize.androidexample.R;
import com.yize.tools.base.BaseFragment;
import com.yize.tools.utils.OtherUtil;

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
    protected void initCreateView(@NonNull View view) {
        TextView tvVersion = view.findViewById(R.id.tv_version);
        tvVersion.setText(OtherUtil.replaceText(tvVersion.getText().toString(), "V1.0"));
        view.findViewById(R.id.bt_jump_project_by_github).setOnClickListener(v -> {
            //跳转项目地址（用浏览器打开）
            Uri uri = Uri.parse("https://github.com/Liyize97126/AndroidExample");
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        });
    }
}