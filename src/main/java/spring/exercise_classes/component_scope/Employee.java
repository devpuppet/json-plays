package spring.exercise_classes.component_scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee extends Person {

    public Employee(@Value("${emp}") String name) {
        super(name);
    }
}
