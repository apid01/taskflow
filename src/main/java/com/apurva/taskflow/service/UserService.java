package com.apurva.taskflow.service;

import com.apurva.taskflow.minispring.annotation.TFAutowired;
import com.apurva.taskflow.minispring.annotation.TFService;
import org.springframework.stereotype.Service;

@TFService
public class UserService {

    @TFAutowired
    private TaskService taskService;

    public UserService() {
        System.out.println("UserService Bean Created");
        Class<UserService> clazz = UserService.class;

    }
}