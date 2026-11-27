
package com.mycompany.campusboot;

import java.lang.reflect.Method;
import java.util.Map;

public class Router {

    public static String dispatch(Container c, String path) {

        Map<String, Object> beans = c.getBeans();

        for (Object bean : beans.values()) {

            Method[] methods = bean.getClass().getDeclaredMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(Route.class)) {

                    Route route = method.getAnnotation(Route.class);

                    if (route.path().equals(path)) {

                        try {

                            method.setAccessible(true);

                            Object result = method.invoke(bean);

                            return String.valueOf(result);

                        } catch (Exception e) {

                            return "500 Internal Server Error";
                        }
                    }
                }
            }
        }

        return "404 Not Found: " + path;
    }
}
