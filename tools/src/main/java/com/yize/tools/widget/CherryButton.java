package com.yize.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.yize.tools.R;
import com.yize.tools.utils.ScaleUtil;

/**
 * @Desc: 带两个樱桃的按钮
 * @Date: 2022年01月18日
 * @Time: 11:46
 * @Author: 李易泽
 */
@SuppressLint("AppCompatCustomView")
public class CherryButton extends Button {
    public CherryButton(Context context) {
        super(context);
        init(context);
    }

    public CherryButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CherryButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 控件初始化
     *
     * @param context 上下文对象
     */
    private void init(Context context) {
        //左右两侧樱桃
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_cherry);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        setCompoundDrawables(drawable, null, drawable, null);
        setMinWidth(0);
        setMinHeight(0);
        setAllCaps(false);
        setTextSize(18f);
        setIncludeFontPadding(false);
        int padding = ScaleUtil.dp2Px(context, 20f);
        setPaddingRelative(padding, padding, padding, padding);
    }
}
