package com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.model.ListDataModel;

import java.util.List;

/**
 * @Desc: 网格列表适配器
 * @Date: 2022年01月18日
 * @Time: 13:15
 * @Author: 李易泽
 */
public class BasicGridListAdapter extends BaseAdapter {
    private List<ListDataModel> mList;
    private Context mContext;

    /**
     * 构造方法
     *
     * @param mList    集合数据
     * @param mContext Context对象
     */
    public BasicGridListAdapter(List<ListDataModel> mList, Context mContext) {
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
        //定义寄存器内部类对象
        MyViewHolder myViewHolder;
        //baseAdapter当convertView只会创建一屏的子布局，下面的布局就不会创建就会服用创建的子布局
        //判断子布局是否为null
        if (convertView == null) {
            //加载条目的子布局
            convertView = View.inflate(mContext, R.layout.layout_grid_list_content_item, null);
            //实例化适配器对象
            myViewHolder = new MyViewHolder();
            //获取资源id
            myViewHolder.mLlItemBg = convertView.findViewById(R.id.ll_item_bg);
            myViewHolder.mIvImage = convertView.findViewById(R.id.iv_image);
            myViewHolder.mTvName = convertView.findViewById(R.id.tv_name);
            //填充内容
            convertView.setTag(myViewHolder);
        } else {
            //否则复用布局
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        //获取条目数据
        ListDataModel listDataModel = mList.get(position);
        //设置条目的数据
        myViewHolder.mIvImage.setImageResource(listDataModel.getImage());
        myViewHolder.mTvName.setText(listDataModel.getName());
        //判断position
        if (position % 2 == 0) {
            myViewHolder.mLlItemBg.setBackgroundColor(Color.parseColor("#FFE5E5"));
        } else {
            myViewHolder.mLlItemBg.setBackgroundColor(Color.parseColor("#E8FFCD"));
        }
        return convertView;
    }

    /**
     * 定义一个寄存器内部类（减少FindViewByid的使用）
     */
    private static class MyViewHolder {
        //定义背景区、图片和文本布局
        private LinearLayout mLlItemBg;
        private ImageView mIvImage;
        private TextView mTvName;
    }
}
