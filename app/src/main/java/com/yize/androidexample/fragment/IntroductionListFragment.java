package com.yize.androidexample.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yize.androidexample.R;
import com.yize.androidexample.adapter.IntroductionListAdapter;
import com.yize.tools.base.BaseFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Desc: 通用介绍列表Fragment
 * @Date: 2021年11月17日
 * @Time: 15:14
 * @Author: 李易泽
 */
public class IntroductionListFragment extends BaseFragment {
    private TextView mTvIntroductionTitle, mTvIntroductionDesc;
    private RecyclerView mRvIntroductionList;
    private IntroductionListAdapter mIntroductionListAdapter;
    private int mTag, mTopicNum;

    private IntroductionListFragment() {
    }

    @NonNull
    public static IntroductionListFragment newInstance(@TagType int tag, int topicNum) {
        IntroductionListFragment fragment = new IntroductionListFragment();
        Bundle args = new Bundle();
        args.putInt("tag", tag);
        args.putInt("topicNum", topicNum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTag = getArguments().getInt("tag");
            mTopicNum = getArguments().getInt("topicNum");
        }
    }

    @Override
    protected int initViewRes() {
        return R.layout.fragment_introduction_list;
    }

    @Override
    protected void initCreateView(@NonNull View view) {
        mTvIntroductionTitle = view.findViewById(R.id.tv_introduction_title);
        mTvIntroductionDesc = view.findViewById(R.id.tv_introduction_desc);
        mRvIntroductionList = view.findViewById(R.id.rv_introduction_list);
        mRvIntroductionList.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        mIntroductionListAdapter = new IntroductionListAdapter();
        mRvIntroductionList.setAdapter(mIntroductionListAdapter);
        //配置页面数据
        initPageInfo();
    }

    /**
     * 配置页面数据
     */
    @SuppressLint("SetTextI18n")
    private void initPageInfo() {
        switch (mTag) {
            case TAB_FIRST: {
                mTvIntroductionTitle.setText(getString(R.string.str_tab_first));
                mTvIntroductionDesc.setText(getString(R.string.str_chapter_topic) + mTopicNum);
                mIntroductionListAdapter.getList().add("");
                mIntroductionListAdapter.getList().add("");
                mIntroductionListAdapter.getList().add("");
                mIntroductionListAdapter.getList().add("");
                mIntroductionListAdapter.notifyDataSetChanged();
            }
            break;
            case TAB_SECOND: {
                mIntroductionListAdapter.getList().add("");
                mIntroductionListAdapter.getList().add("");
                mIntroductionListAdapter.notifyDataSetChanged();
            }
            break;
            default: {
            }
            break;
        }
    }

    /**
     * Tag类型校验
     */
    @IntDef({TAB_FIRST, TAB_SECOND})
    @Retention(RetentionPolicy.SOURCE)
    private @interface TagType {
    }

    public static final int TAB_FIRST = 0;

    public static final int TAB_SECOND = 1;
}
