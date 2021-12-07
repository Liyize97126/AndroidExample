package com.yize.tools.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc: 日期操作工具类
 * @Date: 2021年12月06日
 * @Time: 14:18
 * @Author: 李易泽
 */
public class DateUtil {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将时间字符串转换成Date
     *
     * @param str 时间字符串
     * @return 转换后的Date对象
     */
    public static Date str2Date(String str) {
        return str2Date(str, null);
    }

    /**
     * 将时间字符串转换成Date
     *
     * @param str    时间字符串
     * @param format 格式
     * @return 转换后的Date对象
     */
    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        Date date = null;
        try {
            //TODO 不建议的定义 https://blog.csdn.net/l18848956739/article/details/84887643
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将Date对象转换成时间字符串
     *
     * @param date Date对象
     * @return 转换后的时间字符串
     */
    public static String date2Str(Date date) {
        return date2Str(date, null);
    }

    /**
     * 将Date对象转换成时间字符串
     *
     * @param date   Date对象
     * @param format 格式
     * @return 转换后的时间字符串
     */
    public static String date2Str(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        //TODO 不建议的定义 https://blog.csdn.net/l18848956739/article/details/84887643
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
