package com.yize.tools.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.LayoutRes;
import androidx.annotation.MenuRes;
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
    @SuppressLint("ResourceType")
    private void initActivity(Bundle savedInstanceState) {
        //判断配置
        if (initViewRes() > 0 && !EmptyUtil.isEmpty(initPageTitle())) {
            //设置布局
            setContentView(initViewRes());
            //设置ActionBar
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle(initPageTitle());
            }
        } else {
            throw new IllegalArgumentException("参数配置不正确（布局&页面标题）");
        }
        initView();
        initData();
    }

    /**
     * 添加菜单项
     *
     * @param menu 放置项目的选项菜单
     * @return 菜单是否显示（true表示显示，反之不显示）
     */
    @SuppressLint("ResourceType")
    @Override
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (initMenuRes() > 0) {
            getMenuInflater().inflate(initMenuRes(), menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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
    @LayoutRes
    protected abstract int initViewRes();

    /**
     * 设置页面标题
     *
     * @return 当前的页面标题
     */
    protected abstract String initPageTitle();

    /**
     * 设置更多选项布局
     *
     * @return 更多选项布局Id
     */
    @MenuRes
    protected int initMenuRes() {
        return 0;
    }

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
