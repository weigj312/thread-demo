package com.wei.executor.reject;

import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task "+name+": starting");

        long duration = (long)(Math.random()*10);
        System.out.printf("Task %s: sleep during %d seconds\n",name,duration);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task %s: Ending\n",name);
    }

    @Override
    public String toString() {
        return name;
    }
}
