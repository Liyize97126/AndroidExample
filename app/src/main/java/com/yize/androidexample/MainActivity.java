package com.yize.androidexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ToolBar
        Toolbar toolbar = findViewById(R.id.tb_title);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.dl_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nv_menu_view);

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_test).setDrawerLayout(drawer).build();

        //获取NavController实例
        NavController navController = Navigation.findNavController(this, R.id.fr_host_fragment);
        //将ActionBar与NavController绑定
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fr_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}