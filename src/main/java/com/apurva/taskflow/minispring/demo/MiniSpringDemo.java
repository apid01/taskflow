package com.apurva.taskflow.minispring.demo;

import com.apurva.taskflow.minispring.context.TFApplication;
import com.apurva.taskflow.service.UserService;

import java.lang.reflect.InvocationTargetException;

public class MiniSpringDemo {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        TFApplication.run(UserService.class);
        UserService service =
                (UserService) TFApplication.getBean(UserService.class);

        System.out.println(service);
    }
}
