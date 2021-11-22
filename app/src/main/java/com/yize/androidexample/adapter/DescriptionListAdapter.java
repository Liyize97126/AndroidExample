package com.yize.androidexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yize.androidexample.R;
import com.yize.androidexample.model.DescriptionModel;
import com.yize.tools.base.BaseAdapter;

/**
 * @Desc: 内容详情页列表适配器
 * @Date: 2021年11月22日
 * @Time: 17:30
 * @Author: 李易泽
 */
public class DescriptionListAdapter extends BaseAdapter<DescriptionModel.ContentModel, DescriptionListAdapter.MyViewHolder> {
    private DescriptionListCallBack mDescriptionListCallBack;

    public void setDescriptionListCallBack(DescriptionListCallBack descriptionListCallBack) {
        this.mDescriptionListCallBack = descriptionListCallBack;
    }

    @Override
    protected View initResourceIds(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.layout_description_list_item, viewGroup, false);
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
        DescriptionModel.ContentModel contentModel = getList().get(position);
        holder.mTvDescriptionTitle.setText(contentModel.getTitle());
        if (mDescriptionListCallBack != null) {
            holder.mTvDescriptionViewDemo.setTag(contentModel.getDemoPath());
            holder.mTvDescriptionViewDemo.setOnClickListener(v -> {
                String demoPath = (String) v.getTag();
                try {
                    mDescriptionListCallBack.onViewDemoClick(Class.forName(demoPath));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvDescriptionTitle, mTvDescriptionViewDoc, mTvDescriptionViewDemo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvDescriptionTitle = itemView.findViewById(R.id.tv_description_title);
            mTvDescriptionViewDoc = itemView.findViewById(R.id.tv_description_view_doc);
            mTvDescriptionViewDemo = itemView.findViewById(R.id.tv_description_view_demo);
        }
    }

    /**
     * 列表事件回调
     */
    public interface DescriptionListCallBack {
        /**
         * 条目点击事件（预留，暂不实现）
         */
        default void onItemClick() {
        }

        /**
         * 查看文档事件回调（自定义页面）
         *
         * @param path 跳转路径
         */
        default void onViewDocClick(String path) {
        }

        /**
         * 查看Demo事件回调
         *
         * @param startClass Demo起始类
         */
        void onViewDemoClick(Class<?> startClass);
    }
}
