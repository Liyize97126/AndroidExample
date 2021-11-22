package com.yize.androidexample.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 介绍页列表数据类
 * @Date: 2021年11月22日
 * @Time: 09:47
 * @Author: 李易泽
 */
public class IntroductionModel {
    private long total;
    private ArrayList<ContentModel> contents;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public ArrayList<ContentModel> getContents() {
        return contents;
    }

    public void setContents(ArrayList<ContentModel> contents) {
        this.contents = contents;
    }

    public static class ContentModel implements Parcelable {
        private String itemId;
        private String itemName;
        private List<String> itemContents;

        public ContentModel() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeString(itemId);
            dest.writeString(itemName);
            dest.writeStringList(itemContents);
        }

        protected ContentModel(@NonNull Parcel in) {
            itemId = in.readString();
            itemName = in.readString();
            itemContents = in.createStringArrayList();
        }

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

        public List<String> getItemContents() {
            return itemContents;
        }

        public void setItemContents(List<String> itemContents) {
            this.itemContents = itemContents;
        }

        public static final Creator<ContentModel> CREATOR = new Creator<ContentModel>() {
            @Override
            public ContentModel createFromParcel(Parcel in) {
                return new ContentModel(in);
            }

            @Override
            public ContentModel[] newArray(int size) {
                return new ContentModel[size];
            }
        };
    }
}
