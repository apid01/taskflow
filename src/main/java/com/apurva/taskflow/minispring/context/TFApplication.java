package com.apurva.taskflow.minispring.context;
import com.apurva.taskflow.minispring.annotation.TFService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TFApplication {
    private static final Map<Class<?>, Object> beans = new HashMap<>();
    public static void run(Class<?>... classes) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        for(Class<?> clazz : classes){
            if(clazz.isAnnotationPresent(TFService.class)){
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                Object bean = constructor.newInstance();
                beans.put(clazz, bean);
                System.out.println("Registered Bean : " + clazz.getSimpleName());
                System.out.println(beans);
            }
        }

    }
    public static Object getBean(Class<?> clazz) {
        return beans.get(clazz);
    }
}