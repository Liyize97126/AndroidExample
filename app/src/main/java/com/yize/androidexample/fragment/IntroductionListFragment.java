package com.yize.androidexample.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.yize.androidexample.DescriptionActivity;
import com.yize.androidexample.R;
import com.yize.androidexample.adapter.IntroductionListAdapter;
import com.yize.androidexample.model.IntroductionModel;
import com.yize.tools.base.BaseFragment;
import com.yize.tools.decoration.SplitLineDecoration;
import com.yize.tools.utils.EmptyUtil;
import com.yize.tools.utils.ReadAssetsFileUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/**
 * @Desc: 通用介绍列表Fragment
 * @Date: 2021年11月17日
 * @Time: 15:14
 * @Author: 李易泽
 */
public class IntroductionListFragment extends BaseFragment implements IntroductionListAdapter.IntroductionListCallBack {
    private TextView mTvIntroductionTitle, mTvIntroductionDesc;
    private RecyclerView mRvIntroductionList;
    private IntroductionListAdapter mIntroductionListAdapter;
    private int mTag;
    private AlertDialog mAlertDialog;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                Message message = Message.obtain();
                message.what = 1;
                message.getData().putString("fileName", msg.getData().getString("fileName"));
                mHandler.sendMessageDelayed(message, 2000);
                mAlertDialog.show();
            } else if (msg.what == 1) {
                IntroductionModel introductionModel = initListData(msg.getData().getString("fileName"));
                mTvIntroductionDesc.setText(getString(R.string.str_chapter_topic) + introductionModel.getTotal());
                mIntroductionListAdapter.getList().addAll(introductionModel.getContents());
                mIntroductionListAdapter.notifyDataSetChanged();
                mAlertDialog.dismiss();
            }
        }
    };

    private IntroductionListFragment() {
    }

    @NonNull
    public static IntroductionListFragment newInstance(@TagType int tag) {
        IntroductionListFragment fragment = new IntroductionListFragment();
        Bundle args = new Bundle();
        args.putInt("tag", tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTag = getArguments().getInt("tag");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
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
        mRvIntroductionList.addItemDecoration(new SplitLineDecoration(LinearLayoutManager.VERTICAL));
        mIntroductionListAdapter = new IntroductionListAdapter();
        mRvIntroductionList.setAdapter(mIntroductionListAdapter);
        mIntroductionListAdapter.setIntroductionListCallBack(this);
        mAlertDialog = new AlertDialog.Builder(getContext())
                .setCancelable(false)
                .setView(View.inflate(getContext(), R.layout.layout_loading_dialog, null))
                .create();
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
                Message message = Message.obtain();
                message.what = 0;
                message.getData().putString("fileName", "contents/list/C01.json");
                mHandler.sendMessageDelayed(message, 100);
            }
            break;
            case TAB_SECOND: {
                mIntroductionListAdapter.notifyDataSetChanged();
            }
            break;
            default: {
            }
            break;
        }
    }

    /**
     * 获取列表数据
     */
    private IntroductionModel initListData(String fileName) {
        String json = ReadAssetsFileUtil.readJsonFile(Objects.requireNonNull(getActivity()), fileName);
        if (!EmptyUtil.isEmpty(json)) {
            return new Gson().fromJson(json, IntroductionModel.class);
        }
        return new IntroductionModel();
    }

    /**
     * 列表条目点击事件
     *
     * @param itemId 条目Id
     */
    @Override
    public void onItemClick(String itemId) {
        DescriptionActivity.start(getActivity(), itemId);
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
