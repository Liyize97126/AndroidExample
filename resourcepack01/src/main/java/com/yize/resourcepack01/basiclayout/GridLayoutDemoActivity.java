package com.yize.resourcepack01.basiclayout;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 网格布局演示
 * @Date: 2021年12月03日
 * @Time: 15:01
 * @Author: 李易泽
 */
public class GridLayoutDemoActivity extends BaseDemoActivity implements View.OnClickListener {
    private TextView mTvShowStatus;

    @Override
    protected int initViewRes() {
        return R.layout.activity_grid_layout_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_grid_layout_demo_activity_name);
    }

    @Override
    protected void initView() {
        findViewById(R.id.bt_button_first).setOnClickListener(this);
        findViewById(R.id.bt_button_second).setOnClickListener(this);
        findViewById(R.id.bt_button_third).setOnClickListener(this);
        findViewById(R.id.bt_button_fourth).setOnClickListener(this);
        findViewById(R.id.bt_button_fifth).setOnClickListener(this);
        findViewById(R.id.bt_button_sixth).setOnClickListener(this);
        findViewById(R.id.bt_button_seventh).setOnClickListener(this);
        findViewById(R.id.bt_button_eighth).setOnClickListener(this);
        findViewById(R.id.bt_button_ninth).setOnClickListener(this);
        findViewById(R.id.bt_button_tenth).setOnClickListener(this);
        findViewById(R.id.bt_button_eleventh).setOnClickListener(this);
        findViewById(R.id.bt_button_twelfth).setOnClickListener(this);
        findViewById(R.id.bt_button_thirteenth).setOnClickListener(this);
        findViewById(R.id.bt_button_fourteenth).setOnClickListener(this);
        findViewById(R.id.bt_button_fifteenth).setOnClickListener(this);
        mTvShowStatus = findViewById(R.id.tv_show_status);
    }

    @Override
    protected void initData() {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        String nowButton = ((Button) view).getText().toString();
        mTvShowStatus.setText("您当前按下了\n" + nowButton);
    }
}