package com.ocean.rtmp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xieyuhai on 2018/6/12.
 */

public class User implements Parcelable {


    public int id;
    public String name;
    public String sex;
    public Book book;


    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        sex = in.readString();
        //传递当前线程的类加载器
        book = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeParcelable(book, 0);
    }
}
