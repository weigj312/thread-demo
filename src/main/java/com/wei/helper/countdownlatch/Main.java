package com.wei.helper.countdownlatch;

/**
 * Created by WEI on 2016/12/25.
 */
public class Main {

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);
        Thread conferenceThread = new Thread(conference);
        conferenceThread.start();

        for(int i=0;i<10;i++){
            Participant p = new Participant(conference,"participant"+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
