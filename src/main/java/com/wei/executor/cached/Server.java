package com.wei.executor.cached;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by weiguangjian on 2016/12/26.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }


    public void executeTask(Task task){
        System.out.printf("server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: pool size : %d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Completed Tasks:%d\n",executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }
}
