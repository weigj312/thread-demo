package com.wei.helper.semaphore;

/**
 * Created by WEI on 2016/12/25.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++){
            threads[i] = new Thread(new Job(printQueue),"thread"+i);
        }

        for(Thread t:threads){
            t.start();
        }
    }
}
