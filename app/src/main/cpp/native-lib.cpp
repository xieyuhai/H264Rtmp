#include <jni.h>
#include <string>

extern "C" {
#include "x264.h"
#include "faac.h"
#include "librtmp/rtmp.h"
}

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_ocean_rtmp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";

    x264_picture_t *pic;
    x264_picture_init(pic);

    faacEncGetVersion(NULL, NULL);

    RTMP_Alloc();


    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_ocean_rtmp_push_PushNative_setVideoOptions(JNIEnv *env, jobject instance, jint width,
                                                    jint height, jint bitrate, jint fps) {

    // TODO

}extern "C"
JNIEXPORT void JNICALL
Java_com_ocean_rtmp_push_PushNative_frieVideo(JNIEnv *env, jobject instance, jbyteArray data_) {
    jbyte *data = env->GetByteArrayElements(data_, NULL);

    // TODO

    env->ReleaseByteArrayElements(data_, data, 0);
}