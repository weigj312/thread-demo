package com.wei.executor.fixed;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by weiguangjian on 2016/12/26.
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        for(int i=0;i<100;i++){
            Task task = new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();
        System.out.println("isTerminating:"+server.getExecutors().isTerminating());
        Thread monitorThread = new Thread(new ExecutorMonitor(server.getExecutors()));
        monitorThread.start();
        System.out.println("Main -------------主方法结束---------");
    }

    static class ExecutorMonitor implements Runnable{
        private ThreadPoolExecutor executor;

        public ExecutorMonitor(ThreadPoolExecutor executor) {
            this.executor = executor;
        }

        @Override
        public void run() {
            while (true){
                    if(executor.isTerminated()){
                        System.out.println("线程执行结束");
                        break;
                    }else{
                        System.out.println("ExecutorMonitor-----------corePool task accounts:"+executor.getCorePoolSize());
                        System.out.println("ExecutorMonitor-----------active task accounts:"+executor.getActiveCount());
                        System.out.println("ExecutorMonitor-----------completedTaskCount:"+executor.getCompletedTaskCount());
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
