package com.ocean.rtmp.push;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.util.Log;

import com.ocean.rtmp.params.AudioParams;

/**
 * Created by xieyuhai on 2018/6/18.
 */

public class AudioPusher extends Pusher {

    private static final String TAG = "AudioPusher";

    private AudioRecord audioRecord;
    private AudioParams params;


    private int minBufferSize;


    public AudioPusher(AudioParams params) {
        this.params = params;
        int channelsConfig = params.getChannels() == 1 ? AudioFormat.CHANNEL_IN_MONO : AudioFormat.CHANNEL_IN_STEREO;

        //最小缓冲区大小
        minBufferSize = AudioRecord.getMinBufferSize(params.getSampleRateInHz(), channelsConfig, AudioFormat.ENCODING_PCM_16BIT);

        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                params.getSampleRateInHz(),
                channelsConfig,
                AudioFormat.ENCODING_PCM_16BIT,
                minBufferSize
        );
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


    class AudioRecordTask implements Runnable {
        @Override
        public void run() {
            //开始录音
            audioRecord.startRecording();

            while (isPushing) {
                //通过AudioRecord不断读取音频数据
                byte[] buffer = new byte[minBufferSize];
                int len = audioRecord.read(buffer, 0, buffer.length);

                if (len > 0) {
                    //传给Native代码，进行音频编码
                    Log.e(TAG, "run: 读取音频数据");
                }
            }
        }
    }
}
