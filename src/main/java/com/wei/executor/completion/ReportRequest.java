package com.wei.executor.completion;

import java.util.concurrent.CompletionService;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class ReportRequest implements Runnable {
    private String name;
    private CompletionService service;

    public ReportRequest(String name, CompletionService service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator generator = new ReportGenerator(name,"report");
        service.submit(generator);
    }
}
