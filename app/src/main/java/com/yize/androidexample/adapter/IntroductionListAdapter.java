package com.yize.androidexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yize.androidexample.R;
import com.yize.tools.base.BaseAdapter;

/**
 * @Desc: 介绍页列表适配器
 * @Date: 2021年11月17日
 * @Time: 16:46
 * @Author: 李易泽
 */
public class IntroductionListAdapter extends BaseAdapter<String, IntroductionListAdapter.MyViewHolder> {
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
}
