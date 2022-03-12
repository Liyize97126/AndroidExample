package com.yize.resourcepack01.basiccontrols;

import android.annotation.SuppressLint;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;

/**
 * @Desc: 进度条演示页
 * @Date: 2022年01月21日
 * @Time: 1:33
 * @Author: 李易泽
 */
public class ProgressDemoActivity extends BaseDemoActivity implements SeekBar.OnSeekBarChangeListener {
    private SeekBar mSbSeekBarFirst;
    private SeekBar mSbSeekBarSecond;
    private TextView mTvRatingNumShow;
    private RatingBar mRbRatingBarFirst;

    @Override
    protected int initViewRes() {
        return R.layout.activity_progress_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_progress_demo_activity_name);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        //获取Id
        mSbSeekBarFirst = findViewById(R.id.sb_seek_bar_first);
        mSbSeekBarSecond = findViewById(R.id.sb_seek_bar_second);
        mTvRatingNumShow = findViewById(R.id.tv_rating_num_show);
        mRbRatingBarFirst = findViewById(R.id.rb_rating_bar_first);
        RatingBar rbRatingBarSecond = findViewById(R.id.rb_rating_bar_second);
        //注册事件
        mSbSeekBarFirst.setOnSeekBarChangeListener(this);
        mSbSeekBarSecond.setOnSeekBarChangeListener(this);
        rbRatingBarSecond.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            mRbRatingBarFirst.setRating(rating);
            mTvRatingNumShow.setText("评分星星进度条（" + rating + "/5.0）");
        });
    }

    @Override
    protected void initData() {

    }

    /**
     * 拖拽进度条改变事件(进度改变)
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    /**
     * 拖拽进度条改变事件(开始改变进度)
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * 拖拽进度条改变事件(进度改变停止)
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar == mSbSeekBarFirst) {
            mSbSeekBarSecond.setProgress(mSbSeekBarFirst.getProgress());
        } else if (seekBar == mSbSeekBarSecond) {
            mSbSeekBarFirst.setProgress(mSbSeekBarSecond.getProgress());
        }
    }
}