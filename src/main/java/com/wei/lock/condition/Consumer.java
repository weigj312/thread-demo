package com.wei.lock.condition;

import java.util.Random;

/**
 * Created by weiguangjian on 2016/12/16.
 */
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (buffer.hasPedingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
