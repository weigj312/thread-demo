package com.wei.executor.cancel;

import java.util.concurrent.Callable;

/**
 * Created by weiguangjian on 2017/1/23.
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true){
            System.out.println("Task:Test");
            Thread.sleep(100);
        }
    }
}
