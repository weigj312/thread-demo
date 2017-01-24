package com.wei.executor.done;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by weiguangjian on 2017/1/24.
 */
public class ResultTask extends FutureTask<String> {
    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask)callable).getName();
    }

    @Override
    protected void done() {
        if(isCancelled()){
            System.out.printf("%s: has been canceled\n",name);
        }else{
            System.out.printf("%s has finished\n",name);
        }
    }
}
