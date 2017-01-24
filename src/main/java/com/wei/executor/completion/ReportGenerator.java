package com.wei.executor.completion;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class ReportGenerator implements Callable<String> {
    private String sender;
    private String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {

        long duration = (long)(Math.random()*10);
        System.out.printf("%s_%s:ReportGenerator:Generating a report during %d seconds\n",this.sender,this.title,duration);

        TimeUnit.SECONDS.sleep(duration);
        String ret = sender+": "+title;
        return ret;
    }
}
