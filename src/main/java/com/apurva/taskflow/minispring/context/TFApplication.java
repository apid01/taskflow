package com.apurva.taskflow.minispring.context;
import com.apurva.taskflow.minispring.annotation.TFService;

public class TFApplication {
    public static void run(Class<?>... classes) {
        for(Class<?> clazz : classes){
            if(clazz.isAnnotationPresent(TFService.class)){
                System.out.println("Found TF Service : "+ clazz.getSimpleName());
            }
        }
    }
}