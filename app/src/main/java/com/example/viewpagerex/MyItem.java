package com.example.viewpagerex;

import android.os.Parcel;
import android.os.Parcelable;

class MyItem implements Parcelable {
    private int imageRes;
    private String title;

    public MyItem(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;

    }

    protected MyItem(Parcel in) {
        imageRes = in.readInt();
        title = in.readString();
    }

    public static final Creator<MyItem> CREATOR = new Creator<MyItem>() {
        @Override
        public MyItem createFromParcel(Parcel in) {
            return new MyItem(in);
        }

        @Override
        public MyItem[] newArray(int size) {
            return new MyItem[size];
        }
    };

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageRes);
        dest.writeString(title);
    }
}
