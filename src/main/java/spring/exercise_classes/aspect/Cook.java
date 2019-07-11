package spring.exercise_classes.aspect;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cook implements ICook {

    private List<String> errorList = new ArrayList<>();

    @Override
    public void getIngredients() {
        print("[COOK]: Getting ingredients...");
    }

    @Override
    public void preparePizza() {
        print("[COOK]: Preparing pizza...");
    }

    @Override
    public void deliverPizza() {
        print("[COOK]: Delivering pizza...");
    }

    @Override
    public void preparePasta() {
        throw new RuntimeException("Error while preparing pasta");
    }

    private void print(String value) {
        System.out.println(value);
    }

    @Override
    public void addError(String error) {
        this.errorList.add(error);
    }

    @Override
    public void printErrors() {
        errorList.stream().forEach(e -> System.out.println(e));
    }

}
