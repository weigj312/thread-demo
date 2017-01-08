package com.wei.executor.invokeall;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2017/1/8.
 */
public class Task implements Callable<Result> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() {
        System.out.printf("%s: Staring\n",this.name);

        long duration = (long)(Math.random() * 10);
        System.out.printf("%s: Waiting %d seconds for results.\n",this.name,duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value = 0;
        for(int i=0;i<5;i++){
            value +=(int)(Math.random()*100);
        }
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.printf("%s :ends\n",this.name);
        return result;
    }
}
