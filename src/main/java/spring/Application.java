package spring;

import gson_json.json.JsonHelper;
import json_placeholder_model.request.PostRequest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.SpringMainConfig;
import spring.exercise_classes.aspect.ICook;
import spring.exercise_classes.component_scope.Employee;
import spring.exercise_classes.component_scope.Manager;
import spring.exercise_classes.component_scope.Person;

public class Application {

    private JsonHelper jsonHelper;
    private AnnotationConfigApplicationContext context;

    public void run() {
        context = new AnnotationConfigApplicationContext(SpringMainConfig.class);
        jsonHelper = context.getBean(JsonHelper.class);

        PostRequest emptyPostRequest = (PostRequest) context.getBean("defaultEmptyPostRequest");

        System.out.println(jsonHelper.parseObjectToJson(emptyPostRequest));

        runComponentScopeExercise();
        runAspectExcercise();
    }

    private void runComponentScopeExercise() {
        System.out.println("\n----- Component Scope Exercise -----");

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

    private void runAspectExcercise() {
        System.out.println("\n----- Aspect Excercise -----");

        ICook cook = context.getBean(ICook.class);
        cook.getIngredients();
        cook.preparePizza();
        cook.deliverPizza();
        cook.preparePasta();
        cook.preparePasta();
        cook.printErrors();
    }

}
