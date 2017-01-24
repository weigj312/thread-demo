package com.wei.executor.completion;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class ReportProcessor implements Runnable  {
    private CompletionService<String> service;
    private boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
        while (!end){
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if(result!=null){
                    String report = result.get();
                    System.out.printf("ReportReceiver:report received:%s\n",report);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportSender: end\n");
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
