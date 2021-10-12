package com.yize.androidexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

/**
 * @Description: 首页
 * @Author: YiZe
 * @Date: 2021年10月08日   星期五   09:37
 */
public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    /**
     * NavController实例
     */
    private NavController mNavController;
    private DrawerLayout mDlDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDlDrawerLayout = findViewById(R.id.dl_drawer_layout);
        //ToolBar
        Toolbar toolbar = findViewById(R.id.tb_title);
        setSupportActionBar(toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home).setDrawerLayout(mDlDrawerLayout).build();
        mNavController = Navigation.findNavController(this, R.id.fr_host_fragment);
        NavigationView navigationView = findViewById(R.id.nv_menu_view);
        //将ActionBar与NavController绑定(默认操作栏包含导航支持)
        NavigationUI.setupActionBarWithNavController(this, mNavController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, mNavController);
    }

    /**
     * ToolBar返回键监听
     */
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, appBarConfiguration) || super.onSupportNavigateUp();
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
}