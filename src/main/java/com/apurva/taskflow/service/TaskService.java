package com.apurva.taskflow.service;

import com.apurva.taskflow.minispring.annotation.TFAutowired;
import com.apurva.taskflow.minispring.annotation.TFService;

@TFService
public class TaskService {
    public TaskService() {
        System.out.println("TaskService Bean Created");
        Class<TaskService> clazz = TaskService.class;

    }
}