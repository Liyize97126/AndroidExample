package com.yize.resourcepack01.basiccontrols.listdemoactivities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: 下拉列表演示页
 * @Date: 2022年01月18日
 * @Time: 23:43
 * @Author: 李易泽
 */
public class SpinnerListDemoActivity extends BaseDemoActivity {
    private Spinner mSpiItemFirst;
    private Spinner mSpiItemSecond;
    private Button mBtSubmit;
    private List<String> mAreas;
    private List<String> mCharacter;
    private ArrayAdapter<String> mCharacterAdapter;

    @Override
    protected int initViewRes() {
        return R.layout.activity_spinner_list_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_spinner_list_demo_activity_name);
    }

    @Override
    protected void initView() {
        mSpiItemFirst = findViewById(R.id.spi_item_first);
        mSpiItemSecond = findViewById(R.id.spi_item_second);
        mBtSubmit = findViewById(R.id.bt_submit);
        mBtSubmit.setOnClickListener(v -> {
            String selectedArea = (String) mSpiItemFirst.getSelectedItem();
            String selectedCharacter = (String) mSpiItemSecond.getSelectedItem();
            Toast.makeText(SpinnerListDemoActivity.this,
                    selectedArea + " " + selectedCharacter, Toast.LENGTH_LONG).show();
        });
    }

    @Override
    protected void initData() {
        initArea();
        initCharacter("摩尔城堡");
        //设置适配器
        mSpiItemFirst.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, mAreas));
        mCharacterAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, mCharacter);
        mSpiItemSecond.setAdapter(mCharacterAdapter);
        //设置监听器
        mSpiItemFirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSpiItemSecond.setSelection(0);
                initCharacter(mAreas.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpiItemSecond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mBtSubmit.setEnabled(!"请选择".equals(mCharacter.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * 初始化位置数据
     */
    private void initArea() {
        if (mAreas == null) {
            mAreas = new ArrayList<>();
            mAreas.add("摩尔城堡");
            mAreas.add("爱心街区");
            mAreas.add("淘淘乐街");
            mAreas.add("阳光牧场");
            mAreas.add("开心农场");
            mAreas.add("阳光沙滩");
            mAreas.add("摩尔拉雅雪山");
            mAreas.add("浆果丛林");
            mAreas.add("前哨站");
            mAreas.add("博物岛");
        }
    }

    /**
     * 初始化人物数据
     *
     * @param area 所在位置
     */
    private void initCharacter(String area) {
        if (mCharacter == null) {
            mCharacter = new ArrayList<>();
        } else {
            mCharacter.clear();
        }
        if ("摩尔城堡".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_moer_castle)));
        } else if ("爱心街区".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_love_street)));
        } else if ("淘淘乐街".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_tao_tao_le_street)));
        } else if ("阳光牧场".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_sunshine_ranch)));
        } else if ("开心农场".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_happy_farm)));
        } else if ("阳光沙滩".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_sunshine_beach)));
        } else if ("摩尔拉雅雪山".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_moer_raya_snow_mountain)));
        } else if ("前哨站".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_outpost)));
        } else if ("博物岛".equals(area)) {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_museum_island)));
        } else {
            mCharacter.addAll(Arrays.asList(getResources().getStringArray(R.array.arr_moer_place_berry_jungle)));
        }
        if (mCharacterAdapter != null) {
            mCharacterAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 跳转到此页面
     *
     * @param activity 当前Activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, SpinnerListDemoActivity.class);
        activity.startActivity(intent);
    }
}