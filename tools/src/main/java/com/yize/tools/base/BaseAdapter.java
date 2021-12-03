package com.yize.tools.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yize.tools.utils.EmptyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 适配器基类
 * @Date: 2021年11月17日
 * @Time: 16:21
 * @Author: 李易泽
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    /**
     * 集合数据
     */
    private List<T> mList = new ArrayList<>();
    protected Context mContext;

    @NonNull
    @Override
    public final VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = initResourceIds(LayoutInflater.from(parent.getContext()), parent, viewType);
        mContext = view.getContext();
        return initCreateViewHolder(view, viewType);
    }

    @Override
    public final int getItemCount() {
        return mList.size();
    }

    @Override
    public final int getItemViewType(int position) {
        return bindingViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position, @NonNull List<Object> payloads) {
        if (EmptyUtil.isEmpty(payloads)) {
            onBindViewHolder(holder, position);
        } else {
            onPartialBindViewHolder(holder, position, payloads);
        }
    }

    /**
     * 设置布局Id
     *
     * @param layoutInflater LayoutInflater对象
     * @param viewGroup      ViewGroup对象
     * @param viewType       视图类型
     * @return View对象
     */
    protected abstract View initResourceIds(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType);

    /**
     * 初始化ViewHolder
     *
     * @param view     View视图
     * @param viewType 视图类型
     * @return 创建好的ViewHolder对象
     */
    protected abstract VH initCreateViewHolder(View view, int viewType);

    /**
     * 绑定视图类型
     *
     * @param position 当前条目下标
     * @return 对应的视图类型（viewType）
     */
    protected abstract int bindingViewType(int position);

    /**
     * 绑定ViewHolder（局部刷新）
     *
     * @param holder   视图对象
     * @param position 所属下标
     * @param payloads 标记
     */
    protected void onPartialBindViewHolder(VH holder, int position, List<Object> payloads) {
    }

    /**
     * 得到当前绑定的集合对象
     *
     * @return 当前绑定的集合对象
     */
    public List<T> getList() {
        return mList;
    }

    /**
     * 默认的基类ViewHolder，多条目下使用
     */
    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
