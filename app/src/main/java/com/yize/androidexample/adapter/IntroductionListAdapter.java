package com.yize.androidexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yize.androidexample.R;
import com.yize.androidexample.model.IntroductionModel;
import com.yize.tools.base.BaseAdapter;

/**
 * @Desc: 介绍页列表适配器
 * @Date: 2021年11月17日
 * @Time: 16:46
 * @Author: 李易泽
 */
public class IntroductionListAdapter extends BaseAdapter<IntroductionModel.ContentModel, IntroductionListAdapter.MyViewHolder> {
    private IntroductionListCallBack mIntroductionListCallBack;

    public void setIntroductionListCallBack(IntroductionListCallBack introductionListCallBack) {
        this.mIntroductionListCallBack = introductionListCallBack;
    }

    @Override
    protected View initResourceIds(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.layout_introduction_list_item, viewGroup, false);
    }

    @Override
    protected MyViewHolder initCreateViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    protected int bindingViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IntroductionModel.ContentModel contentModel = getList().get(position);
        holder.mTvItemName.setText(contentModel.getItemName());
        if (contentModel.getItemContents().size() > 0) {
            holder.mIvRightTagStatus.setVisibility(View.VISIBLE);
        } else {
            holder.mIvRightTagStatus.setVisibility(View.GONE);
        }
        if (mIntroductionListCallBack != null) {
            holder.itemView.setTag(contentModel.getItemId());
            holder.itemView.setOnClickListener(v -> mIntroductionListCallBack.onItemClick((String) v.getTag()));
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvItemName;
        private ImageView mIvRightTagStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvItemName = itemView.findViewById(R.id.tv_item_name);
            mIvRightTagStatus = itemView.findViewById(R.id.iv_right_tag_status);
        }
    }

    /**
     * 列表事件回调
     */
    public interface IntroductionListCallBack {
        /**
         * 条目点击事件
         *
         * @param itemId 条目Id
         */
        void onItemClick(String itemId);
    }
}
