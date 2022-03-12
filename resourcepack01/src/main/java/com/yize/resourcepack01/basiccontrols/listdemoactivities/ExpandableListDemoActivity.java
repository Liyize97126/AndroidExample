package com.yize.resourcepack01.basiccontrols.listdemoactivities;

import android.app.Activity;
import android.content.Intent;
import android.widget.ExpandableListView;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter.CustomizeExpandableListAdapter;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 二级列表演示页
 * @Date: 2022年01月19日
 * @Time: 23:34
 * @Author: 李易泽
 */
public class ExpandableListDemoActivity extends BaseDemoActivity {
    private ExpandableListView mElvList;

    @Override
    protected int initViewRes() {
        return R.layout.activity_expandable_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_expandable_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mElvList = findViewById(R.id.elv_list);
    }

    @Override
    protected void initData() {
        //设置适配器
        mElvList.setAdapter(new CustomizeExpandableListAdapter(this));
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ExpandableListDemoActivity.class);
        activity.startActivity(intent);
    }
}