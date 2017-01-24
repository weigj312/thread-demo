package com.wei.executor.done;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2017/1/23.
 */
public class ExecutableTask implements Callable<String> {
    private String name;

    public String getName() {
        return name;
    }

    public ExecutableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {

        long duration = (long)(Math.random()*10);
        System.out.printf("%s:waiting %d seconds for results.\n",this.name,duration);
        TimeUnit.SECONDS.sleep(duration);
        return "Hello,world. I'm"+name;
    }
}
