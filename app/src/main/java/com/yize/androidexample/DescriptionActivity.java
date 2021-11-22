package com.yize.androidexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * @Desc: 内容详情页
 * @Date: 2021年11月22日
 * @Time: 11:28
 * @Author: 李易泽
 */
public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        //ToolBar与ActionBar关联
        Toolbar toolbar = findViewById(R.id.tb_title);
        setSupportActionBar(toolbar);
    }
}