package com.nodmp.algorithm.note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = Collections.synchronizedList(arrayList);

        int i = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    list.add("thread#1-" + i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add("thread#2-" + i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add("thread#3-" + i);
                }
            }
        }).start();

    }
}
