package com.wei.executor.schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2017/1/8.
 */
public class Main {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n",new Date()+"");
        for(int i=0;i<5;i++){
            Task task = new Task("task "+i);
            executor.schedule(task,i+1, TimeUnit.SECONDS);
        }
        //executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        executor.shutdown();

        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Ends at: %s\n",new Date()+"");
    }
}
