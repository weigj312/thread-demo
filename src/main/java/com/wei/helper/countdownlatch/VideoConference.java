package com.wei.helper.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by WEI on 2016/12/25.
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;

    public VideoConference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived\n",name);
        controller.countDown();
        System.out.printf("videoConference :waiting for %d participants\n",controller.getCount());

    }

    public void run() {
        System.out.printf("videoConference :init %d participants\n",controller.getCount());
        try {
            controller.await();
            System.out.printf("all participants has arrived\n");
            System.out.printf("videoConference:let's start....\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
