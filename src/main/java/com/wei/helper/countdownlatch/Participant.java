package com.wei.helper.countdownlatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by WEI on 2016/12/25.
 */
public class Participant implements Runnable {
    private VideoConference videoConference;
    private String name;

    public Participant(VideoConference videoConference, String name) {
        this.videoConference = videoConference;
        this.name = name;
    }

    public void run() {
        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoConference.arrive(name);
    }
}
