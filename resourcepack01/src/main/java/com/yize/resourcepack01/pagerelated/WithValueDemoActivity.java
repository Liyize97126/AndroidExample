package com.yize.resourcepack01.pagerelated;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;
import com.yize.tools.utils.EmptyUtil;
import com.yize.tools.utils.OtherUtil;

/**
 * @Desc: 带传值Activity演示
 * @Date: 2021年12月07日
 * @Time: 14:18
 * @Author: 李易泽
 */
public class WithValueDemoActivity extends BaseDemoActivity implements View.OnClickListener {
    /**
     * 最大页面复用数
     */
    private static final int MAX_REUSE_TIMES = 10;
    private static final String VALUE_TAG = "value";
    private static final String TIMES_TAG = "times";
    private TextView mTvValueByPreviousPage;
    private TextView mTvPageReuseTimes;
    private EditText mEtEnterValue;
    private ImageView mIvGo;
    private String mValueShow, mTimesShow;
    private int mTimes = 0;

    @Override
    protected int initViewRes() {
        return R.layout.activity_with_value_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_with_value_demo_activity_name);
    }

    @Override
    protected void initView() {
        initViewId();
        mValueShow = mTvValueByPreviousPage.getText().toString();
        mTimesShow = mTvPageReuseTimes.getText().toString();
    }

    @Override
    protected void initData() {
        String value = getIntent().getStringExtra(VALUE_TAG);
        mTimes = getIntent().getIntExtra(TIMES_TAG, 0);
        //替换文本
        if (!EmptyUtil.isEmpty(value)) {
            mTvValueByPreviousPage.setText(OtherUtil.replaceText(mValueShow, value));
            mTvPageReuseTimes.setText(OtherUtil.replaceText(mTimesShow, String.valueOf(mTimes)));
        } else {
            mTvValueByPreviousPage.setText("这是首次打开该页面");
            mTvPageReuseTimes.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mIvGo) {
            String enterValue = mEtEnterValue.getText().toString();
            if (!EmptyUtil.isEmpty(enterValue)) {
                if (mTimes < MAX_REUSE_TIMES) {
                    start(this, enterValue, (mTimes + 1));
                } else {
                    Toast.makeText(this, "当前页面已达复用上限，为了节约内存，暂不做页面跳转", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "请输入要传给下一个页面的内容", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * 页面跳转封装
     *
     * @param activity 当前Activity
     * @param value    要传的值
     * @param times    跳转次数
     */
    public static void start(Activity activity, @NonNull String value, int times) {
        Intent intent = new Intent(activity, WithValueDemoActivity.class);
        intent.putExtra(VALUE_TAG, value);
        intent.putExtra(TIMES_TAG, times);
        activity.startActivity(intent);
    }

    /**
     * 获取控件Id
     */
    private void initViewId() {
        mTvValueByPreviousPage = findViewById(R.id.tv_value_by_previous_page);
        mTvPageReuseTimes = findViewById(R.id.tv_page_reuse_times);
        mEtEnterValue = findViewById(R.id.et_enter_value);
        mIvGo = findViewById(R.id.iv_go);
        mIvGo.setOnClickListener(this);
    }
}