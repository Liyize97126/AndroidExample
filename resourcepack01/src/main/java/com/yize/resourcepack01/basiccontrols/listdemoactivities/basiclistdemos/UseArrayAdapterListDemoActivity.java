package com.yize.resourcepack01.basiccontrols.listdemoactivities.basiclistdemos;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 使用ArrayAdapter加载数据的列表演示页
 * @Date: 2021年12月08日
 * @Time: 16:54
 * @Author: 李易泽
 */
public class UseArrayAdapterListDemoActivity extends BaseDemoActivity {
    private TextView mTvTitle;
    private ListView mLvListView;

    @Override
    protected int initViewRes() {
        return R.layout.activity_use_array_adapter_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_use_array_adapter_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mTvTitle = findViewById(R.id.tv_title);
        mLvListView = findViewById(R.id.lv_list_view);
    }

    @Override
    protected void initData() {
        //标题文本跑马灯效果
        mTvTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        mTvTitle.setFocusable(true);
        mTvTitle.setFocusableInTouchMode(true);
        mTvTitle.setMarqueeRepeatLimit(-1);
        mTvTitle.setSelected(true);
        mTvTitle.setSingleLine(true);
        //准备数据源
        //从资源文件中获取字符串数组
        String[] stringArray = getResources().getStringArray(R.array.arr_list_data);
        //设置适配器
        mLvListView.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, stringArray));
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
        Intent intent = new Intent(activity, UseArrayAdapterListDemoActivity.class);
        activity.startActivity(intent);
    }
}