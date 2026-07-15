package com.apurva.taskflow.minispring.demo;

import com.apurva.taskflow.minispring.context.TFApplication;
import com.apurva.taskflow.service.UserService;

public class MiniSpringDemo {
    public static void main(String[] args){
        TFApplication.run(UserService.class);
    }
}
