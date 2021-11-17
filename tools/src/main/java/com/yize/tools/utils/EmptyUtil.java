package com.yize.tools.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Desc: 判空工具类
 * @Date: 2021年11月17日
 * @Time: 16:21
 * @Author: 李易泽
 */
public class EmptyUtil {

    public static boolean isEmpty(CharSequence str) {
        return isNull(str) || str.length() == 0;
    }

    public static boolean isEmpty(Object obj) {
        return isNull(obj);
    }

    public static boolean isEmpty(Object[] obj) {
        return isNull(obj) || obj.length == 0;
    }

    public static boolean isEmpty(Collection<?> list) {
        return isNull(list) || list.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    private static boolean isNull(Object o) {
        return o == null;
    }
}
