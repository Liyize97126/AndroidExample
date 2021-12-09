package com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.model.ListDataModel;

import java.util.List;

/**
 * @Desc: 自定义适配器（基础版）
 * @Date: 2021年12月09日
 * @Time: 10:54
 * @Author: 李易泽
 */
public class CustomizeListAdapter extends BaseAdapter {
    private List<ListDataModel> mList;
    private Context mContext;

    /**
     * 构造方法
     *
     * @param mList    集合数据
     * @param mContext Context对象
     */
    public CustomizeListAdapter(List<ListDataModel> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    /**
     * 得到集合的总数
     *
     * @return 集合的总数
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * 通过位置得到条目
     *
     * @param position 当前位置的下标
     * @return 对应的条目数据
     */
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    /**
     * 得到条目的ID
     *
     * @param position 当前位置的下标
     * @return 对应条目的Id（这里同当前位置的下标）
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 得到子条目视图
     *
     * @param position    当前位置的下标
     * @param convertView 对应子条目的布局
     * @param parent      视图组
     * @return 处理好的子条目视图
     */
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载条目的子布局
        convertView = View.inflate(mContext, R.layout.layout_list_content_item, null);
        //获取当前View包括的资源Id
        ImageView ivImage = convertView.findViewById(R.id.iv_image);
        TextView tvName = convertView.findViewById(R.id.tv_name);
        //获取条目数据
        ListDataModel listDataModel = mList.get(position);
        //设置条目的数据
        ivImage.setImageResource(listDataModel.getImage());
        tvName.setText(listDataModel.getName());
        return convertView;
    }
}
