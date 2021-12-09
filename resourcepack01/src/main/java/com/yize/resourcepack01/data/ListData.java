package com.yize.resourcepack01.data;

import com.yize.resourcepack01.R;
import com.yize.resourcepack01.model.ListDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 列表数据实体
 * @Date: 2021年12月09日
 * @Time: 14:53
 * @Author: 李易泽
 */
public class ListData {
    private static final List<ListDataModel> LIST_DATA = new ArrayList<>();

    static {
        LIST_DATA.add(new ListDataModel(R.mipmap.img_jianghanbo, "江寒波", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_chiyuanshu, "迟远树", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_zhuyuming, "朱煜明", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_yetianyi, "叶天逸", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_lingxiaoshi, "凌小时", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_linxuekai, "林雪开", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_longnisheng, "龙弥生", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_mengmeng, "萌萌", ""));
        LIST_DATA.add(new ListDataModel(R.mipmap.img_linguangjiang, "林广江", ""));
    }

    public static List<ListDataModel> getListData() {
        return LIST_DATA;
    }
}
