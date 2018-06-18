package com.ocean.rtmp.push;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

import com.ocean.rtmp.params.AudioParams;
import com.ocean.rtmp.params.VideoParams;

/**
 * Created by xieyuhai on 2018/6/18.
 */

public class LivePusher {


    private SurfaceHolder surfaceHolder;
    private AudioPusher audioPusher;
    private VideoPusher videoPusher;
    private PushNative pushNative;


    public LivePusher(SurfaceHolder holder) {
        this.surfaceHolder = holder;

        init();
    }

    private void init() {
        audioPusher = new AudioPusher(new AudioParams(44100, 1));
        videoPusher = new VideoPusher(new VideoParams(480, 320, Camera.CameraInfo.CAMERA_FACING_BACK), surfaceHolder);
        pushNative = new PushNative();
        videoPusher.setPushNative(pushNative);
    }

    public void startPush(String url) {
        videoPusher.startPush();
        audioPusher.startPush();
    }

    public void stopPush(String url) {
        videoPusher.stopPush();
        audioPusher.stopPush();
    }

    public void release(){

    }


    //转换摄像头

    public void switchCamera() {
        videoPusher.switchCamera();
    }
}
