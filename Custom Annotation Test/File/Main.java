
package com.mycompany.campusboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Configuration
        Map<String, String> config = new HashMap<>();

        config.put("app.name", "CampusBoot");
        config.put("app.passMark", "40");

        // Create Container
        Container container = new Container();

        // Scan classes
        container.scan(GradeController.class, ReportPrinter.class);

        // Inject values
        container.injectValues(config);

        // Validation
        System.out.println("--- Validation ---");

        for (Student s : List.of(
                new Student(120, 5),
                new Student(85, 5),
                new Student(70, 15))) {

            List<String> errors = Validator.validate(s);

            if (errors.isEmpty()) {
                System.out.println("OK");
            } else {
                errors.forEach(e ->
                        System.out.println("VIOLATION: " + e));
            }
        }

        // Routing
        System.out.println("--- Routing ---");

        for (String p : new String[]{"/hello", "/status", "/unknown"}) {

            System.out.println("[Router] " + p + " -> "
                    + Router.dispatch(container, p));
        }
    }
}
