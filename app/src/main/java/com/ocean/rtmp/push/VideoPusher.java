package com.ocean.rtmp.push;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;

import com.ocean.rtmp.params.VideoParams;

import java.io.IOException;

/**
 * Created by xieyuhai on 2018/6/18.
 */

public class VideoPusher extends Pusher implements SurfaceHolder.Callback, Camera.PreviewCallback {

    private static final String TAG = "VideoPusher";
    private Camera camera;
    private VideoParams params;
    private SurfaceHolder surfaceHolder;
    byte[] buffers;//预览数据

    public VideoPusher(VideoParams params, SurfaceHolder surfaceHolder) {
        this.params = params;
        this.surfaceHolder = surfaceHolder;
        surfaceHolder.addCallback(this);
    }

    private PushNative pushNative;

    public void setPushNative(PushNative pushNative) {
        this.pushNative = pushNative;
    }

    @Override
    public void startPush() {

    }

    @Override
    public void stopPush() {

    }

    @Override
    public void release() {

    }

    //转换摄像头
    public void switchCamera() {
        if (params.getCameraId() == Camera.CameraInfo.CAMERA_FACING_BACK) {
            params.setCameraId(Camera.CameraInfo.CAMERA_FACING_FRONT);
        } else {
            params.setCameraId(Camera.CameraInfo.CAMERA_FACING_BACK);
        }


        //重新预览
        stopPreview();
        startPreview();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startPreview();
    }

    private void startPreview() {
        try {
            pushNative.setVideoOptions(params.getWidth(),
                    params.getHeight(),
                    params.getBitrate(),
                    params.getFps());
//SurfaceView初始化完成，开始相机预览
            camera = Camera.open(params.getCameraId());
            Camera.Parameters parameters = camera.getParameters();
            //设置相机参数
            parameters.setPreviewFormat(ImageFormat.NV21);//YUV  预览图像的像素格式
            parameters.setPreviewSize(params.getWidth(), params.getHeight());
            camera.setParameters(parameters);
//        parameters.setPreviewFpsRange(params.getFps()-1,params.getFps());


            camera.setPreviewDisplay(surfaceHolder);
            //获取预览图像数据
            int bitperPixel = ImageFormat.getBitsPerPixel(ImageFormat.NV21);
//            byte[] buffers = new byte[params.getWidth() * params.getHeight() * 4];
            byte[] buffers = new byte[params.getWidth() * params.getHeight() * bitperPixel / 8];
           //一个 byte[]对象,相机 优化26%
            camera.addCallbackBuffer(buffers);
            camera.setPreviewCallbackWithBuffer(this);
            camera.startPreview();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private void stopPreview() {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    /**
     * 相机预览回调画面
     *
     * @param data
     * @param camera
     */
    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        if (camera != null) {
            //不这样写的话，只会调用一次
            camera.addCallbackBuffer(buffers);
        }

        boolean isBuffer = data == buffers;

        pushNative.frieVideo(data);

        Log.e(TAG, "onPreviewFrame: " + isBuffer);
    }
}
