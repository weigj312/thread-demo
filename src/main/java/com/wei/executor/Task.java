package com.wei.executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2016/12/26.
 */
public class Task implements Runnable {
    private Date initDate;
    private String name;

    public Task(String name) {
        this.name = name;
        initDate = new Date();
    }

    public void run() {
        System.out.printf("%s: Task %s: created on: %s\n",Thread.currentThread().getName(),name,new Date()+"");
        System.out.printf("%s: Task %s: started on: %s\n",Thread.currentThread().getName(),name,new Date()+"");
        long duration = (long)(Math.random()*10);
        System.out.printf("%s: Task %s: doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s:  finished on: %s\n",Thread.currentThread().getName(),name,new Date()+"");
    }
}
