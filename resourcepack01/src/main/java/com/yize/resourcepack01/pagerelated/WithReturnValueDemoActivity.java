package com.yize.resourcepack01.pagerelated;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;
import com.yize.tools.utils.EmptyUtil;

/**
 * @Desc: 传值与回传值Activity演示
 * @Date: 2021年12月07日
 * @Time: 16:38
 * @Author: 李易泽
 */
public class WithReturnValueDemoActivity extends BaseDemoActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 100;
    private static final int RESULT_CODE = 200;
    private static final String VALUE_TAG = "value";
    private static final String RETURN_VALUE_TAG = "return_value";
    private EditText mEtEnterValue;
    private TextView mTvInfoItemFirst;
    private TextView mTvInfoItemSecond;
    private TextView mTvInfoItemThird;
    private Button mBtSubmit;
    private boolean isGetValue;

    @Override
    protected int initViewRes() {
        return R.layout.activity_with_return_value_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_with_return_value_demo_activity_name);
    }

    @Override
    protected void initView() {
        initViewId();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData() {
        String value = getIntent().getStringExtra(VALUE_TAG);
        if (!EmptyUtil.isEmpty(value)) {
            isGetValue = true;
            mBtSubmit.setText("回传值给上一页面");
            mTvInfoItemFirst.setVisibility(View.GONE);
            mTvInfoItemSecond.setText("当前页面传入的值：" + value);
            mTvInfoItemSecond.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
            String returnValue = data.getStringExtra(RETURN_VALUE_TAG);
            mTvInfoItemThird.setText("当前页面得到的回传值：" + returnValue);
            mTvInfoItemThird.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 获取控件Id
     */
    private void initViewId() {
        mEtEnterValue = findViewById(R.id.et_enter_value);
        mTvInfoItemFirst = findViewById(R.id.tv_info_item_first);
        mTvInfoItemSecond = findViewById(R.id.tv_info_item_second);
        mTvInfoItemThird = findViewById(R.id.tv_info_item_third);
        mBtSubmit = findViewById(R.id.bt_submit);
        mBtSubmit.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if (v == mBtSubmit) {
            String value = mEtEnterValue.getText().toString();
            if (!EmptyUtil.isEmpty(value)) {
                if (isGetValue) {
                    Intent intent = new Intent();
                    intent.putExtra(RETURN_VALUE_TAG, value);
                    setResult(RESULT_CODE, intent);
                    finish();
                } else {
                    mTvInfoItemFirst.setVisibility(View.GONE);
                    mTvInfoItemThird.setVisibility(View.GONE);
                    mTvInfoItemSecond.setText("当前页面传出的值：" + value);
                    mTvInfoItemSecond.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(this, WithReturnValueDemoActivity.class);
                    intent.putExtra(VALUE_TAG, value);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            } else {
                Toast.makeText(this, "请输入传值内容", Toast.LENGTH_LONG).show();
            }
        }
    }
}