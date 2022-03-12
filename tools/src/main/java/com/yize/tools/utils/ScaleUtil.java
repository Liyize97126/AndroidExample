package com.yize.tools.utils;

import android.content.Context;

import androidx.annotation.NonNull;

/**
 * @Desc: dp&px转换类
 * @Date: 2022年01月18日
 * @Time: 12:05
 * @Author: 李易泽
 */
public class ScaleUtil {
    /**
     * 构造器
     */
    private ScaleUtil() {
        throw new UnsupportedOperationException("不允许外部实例化此类");
    }

    /**
     * dp转px
     *
     * @param context 上下文对象
     * @param dpValue dp单位的数据
     * @return 转换后的数值
     */
    public static int dp2Px(@NonNull Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
