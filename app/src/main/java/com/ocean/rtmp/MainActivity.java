package com.ocean.rtmp;

import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteCallbackList;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ocean.rtmp.push.LivePusher;

import java.util.HashMap;


/**
 * /data/anr/tract.txt
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 * <p>
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 * <p>
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 */

/**
 * ManagedApplicationService
 * 管理从系统服务器绑定的应用程序提供的服务的生命周期。
 */

/**
 * Binder是客户端和服务端进行通信的媒介，当bindService的时候，服务端会返回一个包含了服务端业务调用的Binder对象
 * 通过这个Binder对象，客户端就可以获取服务端提供的服务或数据，这里的服务包括普通和基于AIDL的服务
 */


/**
 * 推流吗
 * rtmp://send1.douyu.com/live
 *
 * 5127497rYVSkCUb4?wsSecret=cbc358f014f8896d791800a2bc80d164&wsTime=5b2637aa&wsSeek=off&wm=0&tw=0
 */
public class MainActivity extends AppCompatActivity {


    private LivePusher livePusher;
//    private static String URL = "rtmp://47.94.215.46/live/test";

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView surfaceView = findViewById(R.id.surface);
        //相机图像的预览
        livePusher = new LivePusher(surfaceView.getHolder());

    }

    boolean isStart = false;

    public void start(View view) {
        Button btn = (Button) view;

//        if(isStart){
//            btn.setText("停止直播");
//            isStart=false;
//            livePusher.stopPush();
//        }


        if (btn.getText().equals("开始直播")) {
//            livePusher.startPush(URL);
            livePusher.startPush("rtmp://send1.douyu.com/live/5127497rHpjUEbMI?wsSecret=ba1e73fdb5d824837b698b15bca791bc&wsTime=5b274baa&wsSeek=off&wm=0&tw=0");
            btn.setText("停止直播");
        } else {
//            livePusher.stopPush(URL);
            livePusher.stopPush("rtmp://send1.douyu.com/live/5127497rHpjUEbMI?wsSecret=ba1e73fdb5d824837b698b15bca791bc&wsTime=5b274baa&wsSeek=off&wm=0&tw=0");
            btn.setText("开始直播");
        }

    }

    public void switchVideo(View view) {
        livePusher.switchCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        livePusher.release();
    }
}
