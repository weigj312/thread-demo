package com.wei.lock.readwritelock;

/**
 * Created by weiguangjian on 2016/12/15.
 */
public class Writer implements Runnable {
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    public void run() {

        pricesInfo.setPrice(Math.random() * 10, Math.random() * 8);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
