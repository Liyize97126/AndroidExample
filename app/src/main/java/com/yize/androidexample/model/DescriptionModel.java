package com.yize.androidexample.model;

import java.util.ArrayList;

/**
 * @Desc: 内容详情页列表数据类
 * @Date: 2021年11月22日
 * @Time: 17:30
 * @Author: 李易泽
 */
public class DescriptionModel {
    private String itemId;
    private String itemName;
    private String introduction;
    private ArrayList<ContentModel> content;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public ArrayList<ContentModel> getContent() {
        return content;
    }

    public void setContent(ArrayList<ContentModel> content) {
        this.content = content;
    }

    public static class ContentModel {
        private String title;
        private String docPath;
        private String docType;
        private String demoPath;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDocPath() {
            return docPath;
        }

        public void setDocPath(String docPath) {
            this.docPath = docPath;
        }

        public String getDocType() {
            return docType;
        }

        public void setDocType(String docType) {
            this.docType = docType;
        }

        public String getDemoPath() {
            return demoPath;
        }

        public void setDemoPath(String demoPath) {
            this.demoPath = demoPath;
        }
    }
}
