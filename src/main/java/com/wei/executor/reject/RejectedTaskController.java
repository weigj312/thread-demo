package com.wei.executor.reject;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class RejectedTaskController implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskCollector: The task %s has been rejected\n",r.toString());
        System.out.printf("RejectedTaskCollector: %s\n",executor.toString());
        System.out.printf("RejectedTaskCollector: Terminating:%s\n",executor.isTerminating());
        System.out.printf("RejectedTaskCollector: Terminated:%s\n",executor.isTerminated());
    }
}
