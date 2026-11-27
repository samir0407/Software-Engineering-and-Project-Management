
package com.mycompany.campusboot;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class Container {

    private Map<String, Object> beans = new LinkedHashMap<>();

    // Scan classes and register components
    public void scan(Class<?>... classes) {

        for (Class<?> clazz : classes) {

            if (clazz.isAnnotationPresent(Component.class)) {

                try {
                    Component component = clazz.getAnnotation(Component.class);

                    String beanName = component.value();

                    if (beanName.isEmpty()) {
                        beanName = clazz.getSimpleName();
                        beanName = Character.toLowerCase(beanName.charAt(0))
                                + beanName.substring(1);
                    }

                    Object obj = clazz.getDeclaredConstructor().newInstance();

                    beans.put(beanName, obj);

                    System.out.println("[Container] Registered: "
                            + beanName + " (" + clazz.getSimpleName() + ")");

                } catch (Exception e) {
                    System.out.println("[Container] Error creating "
                            + clazz.getSimpleName());
                    e.printStackTrace();
                }

            } else {

                System.out.println("[Container] Skipped: "
                        + clazz.getSimpleName() + " (no @Component)");
            }
        }
    }

    // Inject configuration values
    public void injectValues(Map<String, String> config) {

        for (Map.Entry<String, Object> entry : beans.entrySet()) {

            Object bean = entry.getValue();
            Class<?> clazz = bean.getClass();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(Value.class)) {

                    try {
                        Value valueAnnotation = field.getAnnotation(Value.class);

                        String configKey = valueAnnotation.value();

                        if (!config.containsKey(configKey)) {
                            continue;
                        }

                        String configValue = config.get(configKey);

                        field.setAccessible(true);

                        if (field.getType() == String.class) {

                            field.set(bean, configValue);

                        } else if (field.getType() == int.class
                                || field.getType() == Integer.class) {

                            field.set(bean, Integer.parseInt(configValue));
                        }

                        System.out.println("[Container] Injected: "
                                + configKey + " -> "
                                + clazz.getSimpleName() + "."
                                + field.getName());

                    } catch (Exception e) {
                        System.out.println("[Container] Injection error: "
                                + field.getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Get bean by name
    public Object getBean(String name) {
        return beans.get(name);
    }

    // Return all registered beans
    public Map<String, Object> getBeans() {
        return beans;
    }
}
