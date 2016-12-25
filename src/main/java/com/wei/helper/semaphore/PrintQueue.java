package com.wei.helper.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by WEI on 2016/12/25.
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(){
        try{
            semaphore.acquire();
            long duration = (long)(Math.random()*10);
            System.out.printf("%s printQueue:printing a job during %d second\n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

}
