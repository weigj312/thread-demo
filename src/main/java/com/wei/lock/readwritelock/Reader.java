package com.wei.lock.readwritelock;

/**
 * Created by weiguangjian on 2016/12/15.
 */
public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    public void run() {
            System.out.printf("%s: Price 1:%f\n",Thread.currentThread().getName(),pricesInfo.getPrice1());
            System.out.printf("%s: price 2:%f\n",Thread.currentThread().getName(),pricesInfo.getPrice2());
    }
}
