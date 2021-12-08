package com.yize.tools.utils;

/**
 * @Desc: 其他工具类
 * @Date: 2021年12月07日
 * @Time: 15:41
 * @Author: 李易泽
 */
public class OtherUtil {
    /**
     * 通配符文本替换
     *
     * @param source  源文本
     * @param replace 要替换的内容
     * @return 替换后的文本
     */
    public static String replaceText(String source, String replace) {
        if (source.contains("#%#")) {
            return source.replace("#%#", replace);
        } else {
            return source;
        }
    }
}
