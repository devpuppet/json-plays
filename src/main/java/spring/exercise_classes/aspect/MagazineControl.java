package spring.exercise_classes.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MagazineControl {

    @Pointcut("execution(* spring.exercise_classes.aspect.ICook.getIngredients(..))")
    public void getIngredients() {}

    @Before("getIngredients()")
    public void checkAvailableIngredients() {
        System.out.println("[MAGAZINE CONTROL]: Checking if ingredients are available...");
    }

}
