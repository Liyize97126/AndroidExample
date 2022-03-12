package com.yize.resourcepack01.model;

/**
 * @Desc: 通用数据Model
 * @Date: 2021年12月09日
 * @Time: 10:52
 * @Author: 李易泽
 */
public class ListDataModel {
    private int image;
    private String name;
    private String desc;

    public ListDataModel() {
    }

    public ListDataModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public ListDataModel(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
