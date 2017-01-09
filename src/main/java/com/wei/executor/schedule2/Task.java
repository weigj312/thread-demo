package com.wei.executor.schedule2;

import java.util.Date;

/**
 * Created by weiguangjian on 2017/1/8.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }


    @Override
    public void run()  {
        System.out.printf("%s:Starting at: %s\n",name,new Date()+"");
    }
}
