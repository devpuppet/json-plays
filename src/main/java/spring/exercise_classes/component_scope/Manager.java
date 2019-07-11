package spring.exercise_classes.component_scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Manager extends Person {

    public Manager(@Value("${mgr}") String name) {
        super(name);
    }
}
