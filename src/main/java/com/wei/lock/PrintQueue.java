package com.wei.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by weiguangjian on 2016/12/15.
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document){
        queueLock.lock();
        try{
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+":printQueue:printing a job during"+(duration/1000)+"seconds");
            Thread.sleep(duration);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }
}
