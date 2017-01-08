package com.wei.executor.invokeany;

import java.util.concurrent.Callable;

/**
 * Created by weiguangjian on 2017/1/8.
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;
    private String userName;
    private String password;

    public TaskValidator(UserValidator validator, String userName, String password) {
        this.validator = validator;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if(!validator.validate(userName,password)){
            System.out.printf("%s: the user has not been found\n",validator.getName());
            throw new Exception("Error validating user");
        }

        System.out.printf("%s: the user has been found\n",validator.getName());

        return validator.getName();
    }
}
