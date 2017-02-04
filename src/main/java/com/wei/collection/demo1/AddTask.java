package com.wei.collection.demo1;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by weiguangjian on 2017/2/4.
 */
public class AddTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i=0;i<10000;i++){
            list.add(name+": Element"+i);
        }
    }
}
