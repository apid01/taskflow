package com.apurva.taskflow.minispring.context;
import com.apurva.taskflow.minispring.annotation.TFAutowired;
import com.apurva.taskflow.minispring.annotation.TFService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TFApplication {
    private static final Map<Class<?>, Object> beans = new HashMap<>();

    public static void run(Class<?>... classes) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(TFService.class)) {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                Object bean = constructor.newInstance();
                beans.put(clazz, bean);
                System.out.println("Registered Bean : " + clazz.getSimpleName());
                Field[] fields = clazz.getDeclaredFields();

                for (Field field : fields) {
                    if (field.isAnnotationPresent(TFAutowired.class)) {
                        field.setAccessible(true);
                        Object dependency = getBean(field.getType());
                        field.set(bean, dependency);
                        System.out.println(
                                "Injected "
                                        + field.getType().getSimpleName()
                                        + " into "
                                        + clazz.getSimpleName()
                        );
                    }
                }
            }
        }
    }
    public static <T> T getBean(Class<T> clazz){
        return (T)beans.get(clazz);
    }
}