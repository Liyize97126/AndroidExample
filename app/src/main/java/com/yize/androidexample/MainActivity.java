package com.yize.androidexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.yize.androidexample.fragment.HomeFragment;
import com.yize.androidexample.fragment.IntroductionListFragment;
import com.yize.resourcepack01.basiccontrols.PopupWindowDemoActivity;
import com.yize.tools.utils.DateUtil;

import java.util.Date;

/**
 * @Desc: 首页
 * @Date: 2021年10月08日
 * @Time: 09:37
 * @Author: 李易泽
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDlDrawerLayout;
    private ConstraintLayout mClTopBg;
    private Fragment mFragment;
    private HomeFragment mHomeFragment;
    private IntroductionListFragment mTabFirstFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDlDrawerLayout = findViewById(R.id.dl_drawer_layout);
        mFragmentManager = getSupportFragmentManager();
        NavigationView mNvMenuView = findViewById(R.id.nv_menu_view);
        //获取目录页上方图片背景控件
        mClTopBg = mNvMenuView.getHeaderView(0).findViewById(R.id.cl_top_bg);
        mNvMenuView.setNavigationItemSelectedListener(this);
        //ToolBar与ActionBar关联
        Toolbar toolbar = findViewById(R.id.tb_title);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDlDrawerLayout, toolbar, 0,
                0);
        mDlDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //初始化首页
        mHomeFragment = HomeFragment.newInstance();
        mFragment = mHomeFragment;
        setTitle(getString(R.string.str_home));
        mFragmentManager.beginTransaction().add(R.id.fl_host_page, mFragment).commit();
        //testActivity();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //处理标题图片
        int month = getNowMonth();
        if (month == 12 || month == 1 || month == 2) {
            mClTopBg.setBackgroundResource(R.mipmap.img_winter_drawer_top_bg);
        } else {
            mClTopBg.setBackgroundResource(R.mipmap.img_autumn_drawer_top_bg);
        }
    }

    /**
     * NavigationView切换监听
     *
     * @param item 当前的Item
     * @return 拦截状态
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home: {
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                }
                setTitle(getString(R.string.str_home));
                switchContent(mFragment, mHomeFragment);
            }
            break;
            case R.id.nav_tab_first: {
                if (mTabFirstFragment == null) {
                    mTabFirstFragment = IntroductionListFragment.newInstance(IntroductionListFragment.TAB_FIRST);
                }
                setTitle(getString(R.string.str_tab_first));
                switchContent(mFragment, mTabFirstFragment);
            }
            break;
            default: {
            }
            break;
        }
        item.setChecked(true);
        mDlDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Fragment切换
     *
     * @param fragment1 旧Fragment
     * @param fragment2 新Fragment
     */
    private void switchContent(Fragment fragment1, Fragment fragment2) {
        if (mFragment != fragment2) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.hide(fragment1);
            if (!fragment2.isAdded()) {
                ft.add(R.id.fl_host_page, fragment2).commit();
            } else {
                ft.show(fragment2).commit();
            }
            mFragment = fragment2;
        }
    }

    /**
     * 返回按钮监听
     */
    @Override
    public void onBackPressed() {
        if (mDlDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDlDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 测试Activity
     */
    private void testActivity() {
        startActivity(new Intent(this, PopupWindowDemoActivity.class));
        finish();
    }

    /**
     * 获取当前月份
     *
     * @return 当前的月份
     */
    private int getNowMonth() {
        String mm = DateUtil.date2Str(new Date(), "MM");
        return Integer.parseInt(mm);
    }
}