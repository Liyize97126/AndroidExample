package com.yize.resourcepack01.basiccontrols.listdemoactivities;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter.CustomizeListAdapter;
import com.yize.resourcepack01.data.ListData;
import com.yize.resourcepack01.model.ListDataModel;
import com.yize.tools.base.BaseDemoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 使用自定义Adapter加载数据的列表演示页
 * @Date: 2021年12月09日
 * @Time: 10:20
 * @Author: 李易泽
 */
public class UseCustomizeAdapterListDemoActivity extends BaseDemoActivity {
    private TextView mTvTitle;
    private ListView mLvListView;
    private CustomizeListAdapter mCustomizeListAdapter;
    private List<ListDataModel> mModelList;

    @Override
    protected int initViewRes() {
        return R.layout.activity_use_customize_adapter_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_use_custom_adapter_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mTvTitle = findViewById(R.id.tv_title);
        mLvListView = findViewById(R.id.lv_list_view);
        //给列表添加点击事件
        mLvListView.setOnItemClickListener((parent, view, position, id) -> {
            if (position > 0) {
                int pos = (position - 1);
                String name = mModelList.get(pos).getName();
                String desc = mModelList.get(pos).getDesc();
                Toast.makeText(UseCustomizeAdapterListDemoActivity.this,
                        "点击了第 " + position + " 条数据，" + name + "对你说：" + desc,
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(UseCustomizeAdapterListDemoActivity.this,
                        "这是好友列表，您当前有 " + mModelList.size() + " 位好友",
                        Toast.LENGTH_LONG).show();
            }
        });
        //给列表添加长按事件
        mLvListView.setOnItemLongClickListener((parent, view, position, id) -> {
            if (position > 0) {
                int pos = (position - 1);
                String name = mModelList.get(pos).getName();
                mModelList.remove(pos);
                mCustomizeListAdapter.notifyDataSetChanged();
                Toast.makeText(UseCustomizeAdapterListDemoActivity.this,
                        "好友 " + name + " 删除成功！", Toast.LENGTH_LONG).show();
            }
            return true;
        });
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
        //处理数据
        mModelList = new ArrayList<>();
        mModelList.addAll(ListData.getListData());
        //设置适配器
        mCustomizeListAdapter = new CustomizeListAdapter(mModelList, this);
        mLvListView.setAdapter(mCustomizeListAdapter);
        //加载头部布局
        mLvListView.addHeaderView(View.inflate(this, R.layout.layout_customize_header_view, null));
    }

    @Override
    protected int initMenuRes() {
        return R.menu.menu_first_style;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_jump) {
            //设置滑动到某个item
            mLvListView.setSelection(2);
            Toast.makeText(this, "已跳转至指定位置", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, UseCustomizeAdapterListDemoActivity.class);
        activity.startActivity(intent);
    }
}