package com.wei.collection.demo1;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by weiguangjian on 2017/2/4.
 */
public class PollTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0;i<5000;i++){
            list.pollFirst();
            list.pollLast();
        }
    }
}
