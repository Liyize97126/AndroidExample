package com.yize.tools.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * @Desc: 窗口相关工具类
 * @Date: 2022年01月22日
 * @Time: 13:09
 * @Author: 李易泽
 */
public class WindowUtil {
    /**
     * 构造器
     */
    private WindowUtil() {
        throw new UnsupportedOperationException("不允许外部实例化此类");
    }

    /**
     * 获取顶部状态栏高度
     *
     * @param context 上下文对象
     * @return 顶部状态栏高度
     */
    public static int getStatusBarHeight(@NonNull Context context) {
        int statusBarHeight = 0;
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    /**
     * 获得屏幕宽度
     *
     * @param context 上下文对象
     * @return 屏幕宽度
     */
    public static int getScreenWidth(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕高度
     *
     * @param context 上下文对象
     * @return 屏幕高度
     */
    public static int getScreenHeight(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
