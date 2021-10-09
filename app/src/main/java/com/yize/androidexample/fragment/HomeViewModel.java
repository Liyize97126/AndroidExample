package com.yize.androidexample.fragment;

import com.yize.tools.base.BaseViewModel;

/**
 * @Description: 首页页面数据刷新配置
 * @Author: YiZe
 * @Date: 2021年10月09日   星期六   17:24
 */
public class HomeViewModel extends BaseViewModel<String> {
    public HomeViewModel() {
        mMutableLiveData.setValue("123");
    }
}
