package com.ocean.rtmp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xieyuhai on 2018/6/12.
 */

public class Book implements Parcelable {

    public int id;
    public String name;

    protected Book(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
