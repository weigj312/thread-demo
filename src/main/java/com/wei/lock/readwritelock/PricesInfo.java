package com.wei.lock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by weiguangjian on 2016/12/15.
 */
public class PricesInfo {

    private double price1;
    private double price2;
    private ReadWriteLock lock;

    public PricesInfo() {
        this.price1 = 1.0;
        this.price2 = 2.0;
        this.lock = new ReentrantReadWriteLock();
    }

    public double getPrice1()  {
        lock.readLock().lock();
        double value = price1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
        return value;
    }

    public void setPrice(double price1,double price2){
        lock.writeLock().lock();
        System.out.printf("%s:writer:modify the prices:\n", Thread.currentThread().getName());
        this.price1 = price1;
        this.price2 = price2;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s:writer:prices have been modified.\n", Thread.currentThread().getName());
        lock.writeLock().unlock();
    }
}
