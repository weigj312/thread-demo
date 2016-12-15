package com.wei.lock.readwritelock;

/**
 * Created by weiguangjian on 2016/12/15.
 */
public class Main {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();

        Thread[] readThreads = new Thread[20];
        for(int i=0;i<20;i++){
            Reader reader = new Reader(pricesInfo);
            readThreads[i] = new Thread(reader,"reader_thread:"+i);
        }



        Thread[] writerThreads = new Thread[20];
        for(int i=0;i<20;i++){
            Writer writer = new Writer(pricesInfo);
            writerThreads[i] = new Thread(writer);
        }

        for(Thread t:readThreads){
            t.start();
        }
        for(Thread t:writerThreads){
            t.start();
        }
    }
}
