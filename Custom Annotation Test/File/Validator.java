
package com.mycompany.campusboot;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Range.class)) {

                try {

                    Range range = field.getAnnotation(Range.class);

                    field.setAccessible(true);

                    int actual = field.getInt(obj);

                    if (actual < range.min() || actual > range.max()) {

                        String message = field.getName()
                                + " - " + range.message()
                                + " (actual: " + actual + ")";

                        errors.add(message);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return errors;
    }
}
