package com.yize.resourcepack01.basiccontrols.listdemoactivities;

import android.app.Activity;
import android.content.Intent;
import android.widget.GridView;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter.BasicGridListAdapter;
import com.yize.resourcepack01.data.ListData;
import com.yize.resourcepack01.model.ListDataModel;
import com.yize.tools.base.BaseDemoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 基本网格列表控件演示页
 * @Date: 2022年01月18日
 * @Time: 12:36
 * @Author: 李易泽
 */
public class BasicGridListDemoActivity extends BaseDemoActivity {
    private GridView mGvGridView;

    @Override
    protected int initViewRes() {
        return R.layout.activity_basic_grid_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_basic_grid_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mGvGridView = findViewById(R.id.gv_grid_view);
    }

    @Override
    protected void initData() {
        //处理数据
        List<ListDataModel> modelList = new ArrayList<>(ListData.getListData());
        //设置适配器
        BasicGridListAdapter basicGridListAdapter = new BasicGridListAdapter(modelList, this);
        mGvGridView.setAdapter(basicGridListAdapter);
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, BasicGridListDemoActivity.class);
        activity.startActivity(intent);
    }
}