package com.apurva.taskflow.minispring.scanner;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {
    public static List<Class<?>> scan(String packageName) throws Exception {
        // Convert package name to classpath.
        String path = packageName.replace(".", "/");

        // Locate the package directory from the classpath.
        ClassLoader classLoader = ClassScanner.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File directory = new File(resource.getFile());
        List<Class<?>> classes = new ArrayList<>();

        // Recursively scan the package and its sub-packages.
        scanDirectory(directory, packageName, classes);
        return classes;
    }
    private static void scanDirectory(File directory,
                                      String packageName,
                                      List<Class<?>> classes) throws Exception{
        // Scan package recursively and load classes
        for (File file : directory.listFiles()) {

            if (file.isDirectory()) {

                scanDirectory(
                        file,
                        packageName + "." + file.getName(),
                        classes
                );

            } else if (file.getName().endsWith(".class")) {

                String className = packageName + "."
                        + file.getName().replace(".class", "");

                classes.add(Class.forName(className));
            }
        }
    }
}
