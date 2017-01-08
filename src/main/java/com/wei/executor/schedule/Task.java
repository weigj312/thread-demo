package com.wei.executor.schedule;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by weiguangjian on 2017/1/8.
 */
public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n",name,new Date()+"");

        return "hello world";
    }
}
