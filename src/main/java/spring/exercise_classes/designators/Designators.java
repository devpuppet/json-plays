package spring.exercise_classes.designators;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Designators {

    // when calling a method with int argument
    @Pointcut("args(val)")
    public void integerValue(int val) {}

    @Before("integerValue(value)")
    public void logIntegerValue(int value) {
        System.out.println(String.format("[DESIGNATORS]: Integer value = %s", value));
    }

    // when calling method which argument is annotated with @NotEnough
    @Pointcut("@args(spring.exercise_classes.designators.NotEnough)")
    public void annotation() {}

    @Before("annotation()")
    public void logAnnotationArgument() {
        System.out.println("[DESIGNATORS]: Using class with @NotEnough as an argument!");
    }

    // execution designator examples - look in Communication and MagazineControl for examples

    // when calling methods on Cook objects
    @Pointcut("target(spring.exercise_classes.aspect.Cook)")
    public void type() {}

    @Before("type()")
    public void logType(JoinPoint joinPoint) {
        System.out.println(String.format("[DESIGNATORS]: Caught type = %s",
                joinPoint.getTarget().getClass().getSimpleName()));
    }

    // when calling methods of class annotated with @MasterChef
    @Pointcut("@target(spring.exercise_classes.designators.MasterChef)")
    public void classWithAnnotation() {}

    @Before("classWithAnnotation()")
    public void logClassWithAnnotation() {
        System.out.println(String.format("[DESIGNATORS]: Caught class with @MasterChef annotation"));
    }

    // when calling methods of class being instance of
    @Pointcut("within(spring.exercise_classes.aspect..*)")
    public void withinAspectPackage() {}

    @Before("withinAspectPackage()")
    public void logWithinClasses() {
        System.out.println(String.format("[DESIGNATORS]: Caught object from Aspect package"));
    }

    // when calling any method of class annotated with @MasterChef
    @Pointcut("@within(spring.exercise_classes.designators.MasterChef)")
    public void withinDesignatorsPackage() {}

    @Before("withinDesignatorsPackage()")
    public void logWithDesignatorsPackageAnnotations() {
        System.out.println(String.format("[DESIGNATORS]: Caught ANY method call of type with @MasterChef annotation"));
    }

    // when calling method annotated with @Dangerous
    @Pointcut("@annotation(spring.exercise_classes.designators.Dangerous)")
    public void dangerousMethodAnnotation() {}

    @Before("dangerousMethodAnnotation()")
    public void logDangerousMethodAnnotation() {
        System.out.println(String.format("[DESIGNATORS]: Caught method annotated with @Dangerous. You can cut your finger :("));
    }

    // how to use it?
    @Pointcut("this(spring.exercise_classes.aspect.Cook)")
    public void jsonHelperBean() {}

    @Before("jsonHelperBean()")
    public void logJsonHelperBean() {
        System.out.println(String.format("[DESIGNATORS]: ! "));
    }

}
