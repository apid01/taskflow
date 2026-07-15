package com.apurva.taskflow.service;

import com.apurva.taskflow.minispring.annotation.TFService;
import org.springframework.stereotype.Service;

@TFService
public class UserService {

    public UserService() {
        System.out.println("UserService Bean Created");
        Class<UserService> clazz = UserService.class;

    }
}