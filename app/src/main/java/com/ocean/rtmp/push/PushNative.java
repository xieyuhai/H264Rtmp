package com.ocean.rtmp.push;

/**
 * Created by xieyuhai on 2018/6/18.
 */

public class PushNative {

    //设置视频参数
    public native void setVideoOptions(int width, int height, int bitrate, int fps);

    //推视频流
    public native void frieVideo(byte[] data);
}
