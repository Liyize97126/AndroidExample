package com.yize.tools.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @Description: 页面数据刷新配置
 * @Author: YiZe
 * @Date: 2021年10月09日   星期六   16:43
 */
public abstract class BaseViewModel<T> extends ViewModel {
    /**
     * 创建一个数据列表
     */
    protected MutableLiveData<T> mMutableLiveData;

    public BaseViewModel() {
        mMutableLiveData = new MutableLiveData<>();
    }

    /**
     * 获取MutableLiveData
     * @return 当前MutableLiveData对象
     */
    public MutableLiveData<T> getMutableLiveData() {
        return mMutableLiveData;
    }
}
