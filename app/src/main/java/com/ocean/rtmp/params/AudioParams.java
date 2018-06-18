package com.ocean.rtmp.params;

/**
 * Created by xieyuhai on 2018/6/18.
 */

public class AudioParams {

    //
    private int channels=1;//采样率
    private int sampleRateInHz=44100;//声道个数

    public AudioParams(int sampleRateInHz, int channels) {
        this.channels = channels;
        this.sampleRateInHz = sampleRateInHz;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getSampleRateInHz() {
        return sampleRateInHz;
    }

    public void setSampleRateInHz(int sampleRateInHz) {
        this.sampleRateInHz = sampleRateInHz;
    }
}
