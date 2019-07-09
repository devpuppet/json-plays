package spring;

import gson_json.json.JsonHelper;
import json_placeholder_model.request.PostRequest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.SpringMainConfig;
import spring.exercise_classes.Employee;
import spring.exercise_classes.Manager;
import spring.exercise_classes.Person;

public class Application {

    private JsonHelper jsonHelper;
    private AnnotationConfigApplicationContext context;

    public void run() {
        context = new AnnotationConfigApplicationContext(SpringMainConfig.class);
        jsonHelper = context.getBean(JsonHelper.class);

        PostRequest emptyPostRequest = (PostRequest) context.getBean("defaultEmptyPostRequest");

        System.out.println(jsonHelper.parseObjectToJson(emptyPostRequest));

        runComponentScopeExercise();
    }

    private void runComponentScopeExercise() {
        System.out.println("----- Exercise classes -----");

        Person person = context.getBean(Employee.class);
        Person manager = context.getBean(Manager.class);

        System.out.println(person.introduce());
        System.out.println(manager.introduce());

        System.out.println("changing homes...");

        person.getHome().setHomeType("Small house");
        manager.getHome().setHomeType("Big apartment");

        System.out.println(person.introduce());
        System.out.println(manager.introduce());
    }

}
