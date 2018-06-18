package com.ocean.rtmp;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    @org.junit.Test
    public void Test1() {
        final ExampleUnitTest test = new ExampleUnitTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 100; j++)
                        test.increase();
                }

                ;
            }.start();
        }

        while (Thread.activeCount() > 1) {
            System.out.println("count");
        } //保证前面的线程都执行完
//            Thread.yield();
        System.out.println(test.inc);
    }


    @Test
    public void Test2() {
        System.out.println(Integer.toBinaryString(0x3));
        System.out.print(100 % 3);
        System.out.print(",");
        System.out.print(100 % 3.0);
    }


    @Test
    public void reverse() {
        String a = "abcdefghijklmnopqrst";

        StringBuffer sb = new StringBuffer(a);

        sb.reverse();

        System.out.println(sb.toString());
    }

    @Test
    public void reverse1() {
        String a = "abcdefghijklmnopqrst";
        String result = "";

        int length = a.length();

        for (int i = length - 1; i >= 0; i--) {
            result += a.charAt(i);
        }

        System.out.println(result);
    }


    @Test
    public void dup() {
        String a = "abcdefghijklmnopqrstdsfhshfjdshfdshjfsdiwejewuvwxyzijkdksfksjfklpmllcmscsdbnbsdvn";
        HashSet set = new HashSet();

        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }

        a = "";

        Iterator iter = set.iterator();

        while (iter.hasNext()) {
            a += iter.next();
        }

        Spliterator spliterator = set.spliterator();

        spliterator.forEachRemaining(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.print(o + "  ");
            }
        });

//        System.out.println(a);
    }

    @Test
    public void dup2() {
        String a = "abcdefghijklmnopqrstdsfhshfjdshfdshjfsdiwejewuvwxyzijkdksfksjfklpmllcmscsdbnbsdvn";
        HashMap map = new HashMap();

        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), i);
        }


        Set set = map.keySet();

        set.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.print(o + " ");
            }
        });
    }

    @Test
    public void Test3() {
        System.out.println(a());
    }

    public int a() {
        try {
            int a = 1 / 0;
            return 1;

        } catch (Exception e) {
            return 2;

        } finally {
            return 3;

        }
    }
}