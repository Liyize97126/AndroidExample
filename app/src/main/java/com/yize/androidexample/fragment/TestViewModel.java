package com.yize.androidexample.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yize.androidexample.model.TestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 输入页面描述
 * @Author: YiZe
 * @Date: 2021年10月08日   星期五   11:23
 */
public class TestViewModel extends ViewModel {
    /**
     * 创建一个数据列表
     */
    private MutableLiveData<List<TestModel>> mTestData;

    public TestViewModel() {
        mTestData = new MutableLiveData<>();
        mTestData.setValue(new ArrayList<TestModel>());
    }

    public MutableLiveData<List<TestModel>> getTestData() {
        return mTestData;
    }
}
