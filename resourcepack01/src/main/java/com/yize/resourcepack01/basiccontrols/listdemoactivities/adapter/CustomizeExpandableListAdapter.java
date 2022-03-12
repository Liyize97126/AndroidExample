package com.yize.resourcepack01.basiccontrols.listdemoactivities.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.model.ListDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 二级列表适配器
 * @Date: 2022年01月20日
 * @Time: 0:11
 * @Author: 李易泽
 */
public class CustomizeExpandableListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mGroupList;
    private List<List<ListDataModel>> mContentsList;

    public CustomizeExpandableListAdapter(Context mContext) {
        this.mContext = mContext;
        initListData();
    }

    /**
     * 得到组条目的总数
     *
     * @return 组条目的总数
     */
    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    /**
     * 通过组的位置得到组内数据的总数
     *
     * @param groupPosition 组数据下标
     * @return 对应组数据下标所包含数据的总数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return mContentsList.get(groupPosition).size();
    }

    /**
     * 得到组的位置
     *
     * @param groupPosition 组下标
     * @return 对应的对象
     */
    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    /**
     * 得到子条目的位置
     *
     * @param groupPosition 组数据下标
     * @param childPosition 组内数据下标
     * @return 对应的对象
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    /**
     * 得到组的id
     *
     * @param groupPosition 组数据下标
     * @return 对应的Id
     */
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    /**
     * 得到子条目的id
     *
     * @param groupPosition 组数据下标
     * @param childPosition 组内数据下标
     * @return 对应的Id
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    /**
     * 是否持有稳定的id（不常用）
     *
     * @return 布尔值
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 得到组的视图
     *
     * @param groupPosition 组数据下标
     * @param isExpanded    判断是否进行展开
     * @param convertView   对应的视图
     * @param parent        parent对象
     * @return 配置好的视图对象
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_expandable_list_group_item, null);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.mTvGroupName = convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.mTvGroupName.setText(mGroupList.get(groupPosition));
        return convertView;
    }

    /**
     * 得到组内数据的视图
     *
     * @param groupPosition 组数据下标
     * @param childPosition 组内数据下标
     * @param isLastChild   是否最后一组数据
     * @param convertView   对应的视图
     * @param parent        parent对象
     * @return 配置好的视图对象
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ContentViewHolder contentViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_expandable_list_item, null);
            contentViewHolder = new ContentViewHolder();
            contentViewHolder.mIvImage = convertView.findViewById(R.id.iv_image);
            contentViewHolder.mTvName = convertView.findViewById(R.id.tv_name);
            convertView.setTag(contentViewHolder);
        } else {
            contentViewHolder = (ContentViewHolder) convertView.getTag();
        }
        contentViewHolder.mIvImage.setImageResource(mContentsList.get(groupPosition).get(childPosition).getImage());
        contentViewHolder.mTvName.setText(mContentsList.get(groupPosition).get(childPosition).getName());
        return convertView;
    }

    /**
     * 当前条目是否可以进行点击
     *
     * @param groupPosition 组数据下标
     * @param childPosition 组内数据下标
     * @return 布尔值
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     * 初始化数据
     */
    private void initListData() {
        //初始化外部集合
        mGroupList = new ArrayList<>();
        mContentsList = new ArrayList<>();
        //初始化男主的数据
        ArrayList<ListDataModel> groupFirst = new ArrayList<>();
        groupFirst.add(new ListDataModel(R.mipmap.img_jianghanbo, "江寒波"));
        groupFirst.add(new ListDataModel(R.mipmap.img_chiyuanshu, "迟远树"));
        groupFirst.add(new ListDataModel(R.mipmap.img_zhuyuming, "朱煜明"));
        groupFirst.add(new ListDataModel(R.mipmap.img_yetianyi, "叶天逸"));
        groupFirst.add(new ListDataModel(R.mipmap.img_lingxiaoshi, "凌小时"));
        groupFirst.add(new ListDataModel(R.mipmap.img_linxuekai, "林雪开"));
        groupFirst.add(new ListDataModel(R.mipmap.img_longnisheng, "龙弥生"));
        groupFirst.add(new ListDataModel(R.mipmap.img_linguangjiang, "林广江"));
        groupFirst.add(new ListDataModel(R.mipmap.img_mengmeng, "萌萌（闺蜜）"));
        //初始化女主的数据
        ArrayList<ListDataModel> groupSecond = new ArrayList<>();
        groupSecond.add(new ListDataModel(R.mipmap.img_zhanghanzhi, "章涵之"));
        groupSecond.add(new ListDataModel(R.mipmap.img_qingyulu, "秦屿路"));
        groupSecond.add(new ListDataModel(R.mipmap.img_liupianpian, "刘偏偏"));
        groupSecond.add(new ListDataModel(R.mipmap.img_ximenglai, "席梦来"));
        groupSecond.add(new ListDataModel(R.mipmap.img_wangshengnan, "王胜男"));
        groupSecond.add(new ListDataModel(R.mipmap.img_liruofang, "李若放"));
        groupSecond.add(new ListDataModel(R.mipmap.img_tangjinna, "汤金娜"));
        groupSecond.add(new ListDataModel(R.mipmap.img_sufangyun, "苏芳允（朱提亚）"));
        //绑定数据
        mGroupList.add("男主（共" + groupFirst.size() + "位）");
        mGroupList.add("女主（共" + groupSecond.size() + "位）");
        mContentsList.add(groupFirst);
        mContentsList.add(groupSecond);
    }

    private static class GroupViewHolder {
        private TextView mTvGroupName;
    }

    private static class ContentViewHolder {
        private ImageView mIvImage;
        private TextView mTvName;
    }
}
