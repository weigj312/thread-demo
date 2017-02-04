package com.wei.collection.demo3;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by weiguangjian on 2017/2/4.
 */
public class Task implements Runnable {

    private int id;
    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            Event event = new Event(id,i);
            queue.add(event);
        }
    }
}
