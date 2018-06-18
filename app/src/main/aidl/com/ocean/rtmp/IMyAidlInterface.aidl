// IMyAidlInterface.aidl
package com.ocean.rtmp;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                                                        double aDouble, String aString);


    void basicTypes1(int anInt, long aLong, boolean aBoolean, float aFloat,
                                                                    double aDouble, String aString);
}
