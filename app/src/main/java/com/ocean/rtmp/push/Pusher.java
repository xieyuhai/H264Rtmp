package com.ocean.rtmp.push;

/**
 * Created by xieyuhai on 2018/6/18.
 */

public abstract class Pusher {

    public boolean isPushing = false;

    public abstract void startPush();

    public abstract void stopPush();

    public abstract void release();
}
