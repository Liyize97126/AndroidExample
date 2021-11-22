package com.yize.androidexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.yize.androidexample.adapter.DescriptionListAdapter;
import com.yize.androidexample.model.DescriptionModel;
import com.yize.tools.decoration.SplitLineDecoration;
import com.yize.tools.utils.EmptyUtil;
import com.yize.tools.utils.ReadAssetsFileUtil;

import java.util.Objects;

/**
 * @Desc: 内容详情页
 * @Date: 2021年11月22日
 * @Time: 11:28
 * @Author: 李易泽
 */
public class DescriptionActivity extends AppCompatActivity implements DescriptionListAdapter.DescriptionListCallBack {
    private DescriptionListAdapter mDescriptionListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        //ToolBar与ActionBar关联
        Toolbar toolbar = findViewById(R.id.tb_title);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.str_topic_details));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        TextView tvDescriptionTitle = findViewById(R.id.tv_description_title);
        TextView tvDescriptionDesc = findViewById(R.id.tv_description_desc);
        RecyclerView rvDescriptionList = findViewById(R.id.rv_description_list);
        rvDescriptionList.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));
        rvDescriptionList.addItemDecoration(new SplitLineDecoration(LinearLayoutManager.VERTICAL));
        mDescriptionListAdapter = new DescriptionListAdapter();
        rvDescriptionList.setAdapter(mDescriptionListAdapter);
        mDescriptionListAdapter.setDescriptionListCallBack(this);
        //接收路径数据
        String jsonPath = getIntent().getStringExtra("jsonPath");
        String json = ReadAssetsFileUtil.readJsonFile(this, "contents/contentdata/" + jsonPath);
        if (!EmptyUtil.isEmpty(json)) {
            DescriptionModel descriptionModel = new Gson().fromJson(json, DescriptionModel.class);
            tvDescriptionTitle.setText(descriptionModel.getItemName());
            tvDescriptionDesc.setText(descriptionModel.getIntroduction());
            mDescriptionListAdapter.getList().addAll(descriptionModel.getContent());
            mDescriptionListAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "数据异常或无数据", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     * @param itemId   条目Id
     */
    public static void start(Activity activity, @NonNull String itemId) {
        Intent intent = new Intent(activity, DescriptionActivity.class);
        intent.putExtra("jsonPath", itemId + ".json");
        activity.startActivity(intent);
    }

    /**
     * 按键拦截事件
     *
     * @param item 选项
     * @return 是否消费事件
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Demo跳转
     *
     * @param startClass Demo起始类
     */
    @Override
    public void onViewDemoClick(Class<?> startClass) {
        startActivity(new Intent(DescriptionActivity.this, startClass));
    }
}