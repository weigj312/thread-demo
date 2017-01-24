package com.wei.executor.completion;

import java.util.concurrent.*;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        ReportRequest faceRequest = new ReportRequest("Face",service);
        ReportRequest onlineRequest = new ReportRequest("Online",service);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);

        ReportProcessor processor = new ReportProcessor(service);
        Thread senderThread = new Thread(processor);

        System.out.printf("Main: starting the Thread\n");
        faceThread.start();
        onlineThread.start();
        senderThread.start();

        System.out.printf("Main: Waiting for the report generators.\n");

        try {
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: shutting down the executor.\n");
        executor.shutdown();

        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.setEnd(true);
        System.out.println("Main: ends");

    }
}
