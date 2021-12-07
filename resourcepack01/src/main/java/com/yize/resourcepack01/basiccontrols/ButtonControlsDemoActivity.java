package com.yize.resourcepack01.basiccontrols;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 按钮相关控件演示页
 * @Date: 2021年12月06日
 * @Time: 15:31
 * @Author: 李易泽
 */
public class ButtonControlsDemoActivity extends BaseDemoActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,
        CompoundButton.OnCheckedChangeListener {
    private Button mBtButton;
    private ImageButton mIbtImageButton;
    private CheckBox mCbCheckBoxFirst, mCbCheckBoxSecond;
    private Switch mSwSwitch;
    /**
     * 图片按钮状态
     */
    private boolean mImageButtonStatus = false;

    @Override
    protected int initViewRes() {
        return R.layout.activity_button_controls_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_button_controls_demo_activity_name);
    }

    @Override
    protected void initView() {
        initViewIds();
    }

    @Override
    protected void initData() {

    }

    /**
     * 获取控件Id
     */
    private void initViewIds() {
        mBtButton = findViewById(R.id.bt_button);
        mBtButton.setOnClickListener(this);
        mBtButton.setOnLongClickListener(view -> {
            mBtButton.setText("您长按了该按钮");
            //返回值：在长按事件与点击事件同时设置的情况下，
            //true代表不允许响应点击事件，false代表允许响应点击事件
            return true;
        });
        mIbtImageButton = findViewById(R.id.ibt_image_button);
        mIbtImageButton.setOnClickListener(this);
        RadioGroup rgRadioGroup = findViewById(R.id.rg_radio_group);
        rgRadioGroup.setOnCheckedChangeListener(this);
        mCbCheckBoxFirst = findViewById(R.id.cb_check_box_first);
        mCbCheckBoxFirst.setOnCheckedChangeListener(this);
        mCbCheckBoxSecond = findViewById(R.id.cb_check_box_second);
        mCbCheckBoxSecond.setOnCheckedChangeListener(this);
        mSwSwitch = findViewById(R.id.sw_switch);
        mSwSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mBtButton) {
            mBtButton.setText("您按过了该按钮");
        } else if (view == mIbtImageButton) {
            if (mImageButtonStatus) {
                mImageButtonStatus = false;
                mIbtImageButton.setImageResource(android.R.drawable.ic_menu_call);
            } else {
                mImageButtonStatus = true;
                mIbtImageButton.setImageResource(android.R.drawable.ic_menu_camera);
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //检查radioGroup下包含的控件id
        if (i == R.id.rb_radio_button_first) {
            Toast.makeText(this, "选择了A项", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.rb_radio_button_second) {
            Toast.makeText(this, "选择了B项", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.rb_radio_button_third) {
            Toast.makeText(this, "选择了C项", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "选择了?项", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton == mCbCheckBoxFirst) {
            Toast.makeText(this, "复选按钮1  当前状态：" + b, Toast.LENGTH_SHORT).show();
        } else if (compoundButton == mCbCheckBoxSecond) {
            Toast.makeText(this, "复选按钮2  当前状态：" + b, Toast.LENGTH_SHORT).show();
        } else if (compoundButton == mSwSwitch) {
            if (b) {
                Toast.makeText(this, "您打开了这个开关", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "您关闭了这个开关", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "复选按钮?  当前状态：" + b, Toast.LENGTH_SHORT).show();
        }
    }
}