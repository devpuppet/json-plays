package spring.exercise_classes.aspect.extensions;

public class Toast implements IToast {
    @Override
    public void prepareToast() {
        System.out.println("[TOAST] Preparing toast...");
    }
}
