package com.wei.executor.reject;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class Main {
    public static void main(String[] args) {
        RejectedTaskController controller = new RejectedTaskController();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(controller);

        System.out.printf("Main: starting.\n");
        for(int i=0;i<3;i++){
            Task task = new Task("task"+i);
            executor.submit(task);
        }

        System.out.printf("Main: shutting down the Executor.\n");
        executor.shutdown();
        System.out.printf("Main: sending another task.\n");
        Task task = new Task("RejectedTask");
        executor.submit(task);

        System.out.println("Main:end");

    }

}
