package com.yize.tools.base;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.yize.tools.utils.EmptyUtil;

/**
 * @Desc: DemoActivity基类
 * @Date: 2021年11月21日
 * @Time: 22:51
 * @Author: 李易泽
 */
public abstract class BaseDemoActivity extends AppCompatActivity {

    /**
     * OnCreate方法
     *
     * @param savedInstanceState 意外退出保存的数据
     */
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity(savedInstanceState);
    }

    /**
     * 初始化Activity页面
     *
     * @param savedInstanceState 意外退出保存的数据
     */
    private void initActivity(Bundle savedInstanceState) {
        //判断配置
        if (initViewRes() > 0 && !EmptyUtil.isEmpty(initPageTitle())) {
            //设置布局
            setContentView(initViewRes());
            //设置ActionBar
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(initPageTitle());
        } else {
            throw new IllegalArgumentException("参数配置不正确（布局&页面标题）");
        }
        initView();
        initData();
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
     * 设置布局Id
     *
     * @return 当前的布局Id
     */
    protected abstract int initViewRes();

    /**
     * 设置页面标题
     *
     * @return 当前的页面标题
     */
    protected abstract String initPageTitle();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
