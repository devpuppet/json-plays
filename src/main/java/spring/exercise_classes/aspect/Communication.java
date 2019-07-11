package spring.exercise_classes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Communication {

    @Pointcut("execution(* spring.exercise_classes.aspect.ICook.getIngredients(..))")
    public void getIngredients() {}

    @Pointcut("execution(* spring.exercise_classes.aspect.ICook.deliverPizza(..))")
    public void deliverPizza() {}

    @Pointcut("execution(* spring.exercise_classes.aspect.ICook.preparePasta(..))")
    public void preparePasta() {}

    @After("getIngredients()")
    public void informIngredientsGathered() {
        System.out.println("[COMMUNICATION]: Ingredients have been gathered.");
    }

    @Around("deliverPizza()")
    public void informPizzaDelivery(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("[COMMUNICATION]: Pizza is ready to be delivered.");
            joinPoint.proceed();
            System.out.println("[COMMUNICATION]: Pizza has been delivered.");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Around("preparePasta()")
    public void handleErrors(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("[ERROR]: Cook can prepare only pizza!");
            ICook cook = (ICook) joinPoint.getTarget();
            cook.addError(throwable.getMessage());
        }
    }

}
