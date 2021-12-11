package com.yize.resourcepack01.basiccontrols.listdemoactivities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter.CustomizeAdvancedListAdapter;
import com.yize.resourcepack01.data.ListData;
import com.yize.resourcepack01.model.ListDataModel;
import com.yize.tools.base.BaseDemoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 使用自定义Adapter(进阶版)加载数据的列表演示页
 * @Date: 2021年12月10日
 * @Time: 15:19
 * @Author: 李易泽
 */
public class UseCustomizeAdapterAdvancedListDemoActivity extends BaseDemoActivity
        implements AbsListView.OnScrollListener {
    private ListView mLvListView;
    private CustomizeAdvancedListAdapter mCustomizeAdvancedListAdapter;
    private List<ListDataModel> mModelList;

    @Override
    protected int initViewRes() {
        return R.layout.activity_use_customize_adapter_advanced_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_use_custom_adapter_advanced_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mLvListView = findViewById(R.id.lv_list_view);
        //设置滑动监听
        mLvListView.setOnScrollListener(this);
    }

    @Override
    protected void initData() {
        //处理数据
        mModelList = new ArrayList<>();
        mModelList.addAll(ListData.getListData());
        //设置适配器
        mCustomizeAdvancedListAdapter = new CustomizeAdvancedListAdapter(mModelList, this);
        mLvListView.setAdapter(mCustomizeAdvancedListAdapter);
        //在底部添加进度条
        ProgressBar bar = new ProgressBar(this);
        mLvListView.addFooterView(bar);
    }

    public void resetData(View view) {
        //重新加载数据
        mModelList.clear();
        mModelList.addAll(ListData.getListData());
        mCustomizeAdvancedListAdapter.notifyDataSetChanged();
        mLvListView.setSelection(0);
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, UseCustomizeAdapterAdvancedListDemoActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 滑动改变监听
     *
     * @param view        当前View
     * @param scrollState 滑动状态
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        /*AbsListView.OnScrollListener.SCROLL_STATE_IDLE  停止
                AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL 触摸滑
                AbsListView.OnScrollListener.SCROLL_STATE_FLING 惯性滑动*/
        //scrollState得到Listview的状态
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            //当前list view最后一个数据的位置 == 集合的长度
            if (mLvListView.getLastVisiblePosition() == mModelList.size()) {
                //加载新的数据
                mModelList.addAll(ListData.getListData());
                mCustomizeAdvancedListAdapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * 滑动事件
     *
     * @param view             当前的ListView
     * @param firstVisibleItem 第一条可见的条目
     * @param visibleItemCount 显示条目的总数
     * @param totalItemCount   全部条目的数量
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}