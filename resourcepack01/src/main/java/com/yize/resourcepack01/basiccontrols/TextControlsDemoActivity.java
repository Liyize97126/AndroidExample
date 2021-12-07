package com.yize.resourcepack01.basiccontrols;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;
import com.yize.tools.utils.EmptyUtil;

/**
 * @Desc: 文本相关控件演示页
 * @Date: 2021年12月04日
 * @Time: 11:47
 * @Author: 李易泽
 */
public class TextControlsDemoActivity extends BaseDemoActivity {
    private TextView mTvTextShow;
    private EditText mEtEditText;

    @Override
    protected int initViewRes() {
        return R.layout.activity_text_controls_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_text_controls_demo_activity_name);
    }

    @Override
    protected void initView() {
        mTvTextShow = findViewById(R.id.tv_text_show);
        mEtEditText = findViewById(R.id.et_edit_text);
    }

    @Override
    protected void initData() {

    }

    /**
     * 按钮提交事件
     *
     * @param view 当前View
     */
    public void submit(View view) {
        String showText = mEtEditText.getText().toString();
        if (!EmptyUtil.isEmpty(showText)) {
            mTvTextShow.setText(showText);
        } else {
            Toast.makeText(this, "请输入文本", Toast.LENGTH_SHORT).show();
        }
    }
}