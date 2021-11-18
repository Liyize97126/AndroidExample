package com.yize.tools.utils;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Desc: 读取Assets文件工具类
 * @Date: 2021年11月18日
 * @Time: 14:48
 * @Author: 李易泽
 */
public class ReadAssetsFileUtil {
    /**
     * 读取Json类型文件
     *
     * @param activity Activity对象
     * @param fileName 文件名（路径）
     * @return 返回处理好的Json原文本
     */
    @Nullable
    public static String readJsonFile(@NonNull Activity activity, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bf = null;
        try {
            InputStream is = activity.getResources().getAssets().open(fileName);
            bf = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
