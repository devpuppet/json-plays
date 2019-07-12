package spring.exercise_classes.aspect.extensions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ToastAspect {

    @DeclareParents(value = "spring.exercise_classes.aspect.ICook+", defaultImpl = Toast.class)
    public static IToast iToast;

}
