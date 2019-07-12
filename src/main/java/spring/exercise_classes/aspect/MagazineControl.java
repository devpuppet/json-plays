package spring.exercise_classes.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MagazineControl {

    @Pointcut("execution(* spring.exercise_classes.aspect.ICook.getIngredients(..))")
    public void getIngredients() {}

    @Before("getIngredients()")
    public void checkAvailableIngredients(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String amount = "";
        if (args.length != 0) {
            amount = ((Integer) args[0]).toString() + " ";
        }

        System.out.println(String.format("[MAGAZINE CONTROL]: Checking if %singredients are available...", amount));

    }

}
