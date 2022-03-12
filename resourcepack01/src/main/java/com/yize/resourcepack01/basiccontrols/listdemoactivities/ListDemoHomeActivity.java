package com.yize.resourcepack01.basiccontrols.listdemoactivities;

import android.view.View;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.basiclistdemos.BasicListDemoActivity;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.basiclistdemos.UseArrayAdapterListDemoActivity;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.basiclistdemos.UseCustomizeAdapterAdvancedListDemoActivity;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.basiclistdemos.UseCustomizeAdapterListDemoActivity;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 列表相关控件演示起始页
 * @Date: 2021年12月08日
 * @Time: 11:05
 * @Author: 李易泽
 */
public class ListDemoHomeActivity extends BaseDemoActivity {
    @Override
    protected int initViewRes() {
        return R.layout.activity_list_demo_home;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_list_demo_activity_name);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public void basicList(View view) {
        BasicListDemoActivity.start(this);
    }

    public void useArrayAdapterList(View view) {
        UseArrayAdapterListDemoActivity.start(this);
    }

    public void useCustomizeAdapterList(View view) {
        UseCustomizeAdapterListDemoActivity.start(this);
    }

    public void useCustomizeAdapterAdvancedList(View view) {
        UseCustomizeAdapterAdvancedListDemoActivity.start(this);
    }

    public void basicGridList(View view) {
        BasicGridListDemoActivity.start(this);
    }

    public void expandableList(View view) {
        ExpandableListDemoActivity.start(this);
    }

    public void spinnerList(View view) {
        SpinnerListDemoActivity.start(this);
    }

    public void galleryList(View view) {
    }
}