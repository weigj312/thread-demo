package com.wei.helper.semaphore2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WEI on 2016/12/25.
 */
public class PrintQueue {
    private final Semaphore semaphore;
    private boolean[] freePrinters;
    private Lock lockPrinters;
    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        lockPrinters = new ReentrantLock();
        for(int i=0;i<3;i++){
            freePrinters[i] = true;
        }
    }


    public void printJob(){
        try{
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            long duration = (long)(Math.random()*10);
            System.out.printf("%s printQueue:printing a job during %d second\n",Thread.currentThread().getName(),duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private int getPrinter(){
        int ret = -1;
        try{
            lockPrinters.lock();
            for(int i=0;i<freePrinters.length;i++){
                if(freePrinters[i]){
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lockPrinters.unlock();
        }
        return ret;
    }

}
