package spring.exercise_classes.component_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:name.properties")
public class Person {

    @Autowired
    private Home home;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String introduce() {
        return String.format("This is %s. He is a %s. He is living in %s",
                name, this.getClass().getSimpleName(), home.toString());
    }

    public Home getHome() {
        return this.home;
    }

}
