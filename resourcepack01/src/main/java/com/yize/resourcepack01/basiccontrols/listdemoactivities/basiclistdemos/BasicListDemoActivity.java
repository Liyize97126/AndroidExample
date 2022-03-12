package com.yize.resourcepack01.basiccontrols.listdemoactivities.basiclistdemos;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 基本列表控件演示页
 * @Date: 2021年12月08日
 * @Time: 11:41
 * @Author: 李易泽
 */
public class BasicListDemoActivity extends BaseDemoActivity {
    private ListView mLvListView;

    @Override
    protected int initViewRes() {
        return R.layout.activity_basic_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_basic_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mLvListView = findViewById(R.id.lv_list_view);
    }

    @Override
    protected void initData() {
        //加载头部布局
        mLvListView.addHeaderView(View.inflate(this, R.layout.layout_header_view, null));
        //加载尾部布局
        mLvListView.addFooterView(View.inflate(this, R.layout.layout_footer_view, null));
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, BasicListDemoActivity.class);
        activity.startActivity(intent);
    }
}