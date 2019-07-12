package spring.exercise_classes.aspect;

import org.springframework.stereotype.Component;
import spring.exercise_classes.designators.Dangerous;
import spring.exercise_classes.designators.MasterChef;
import spring.exercise_classes.designators.Salary;

import java.util.ArrayList;
import java.util.List;

@MasterChef
@Component
public class Cook implements ICook {

    private List<String> errorList = new ArrayList<>();

    @Override
    public void getIngredients() {
        print("[COOK]: Getting ingredients...");
    }

    @Override
    public void getIngredients(int amount) {
        print("[COOK]: Getting " + amount + " ingredients...");
    }

    @Override
    @Dangerous
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

    @Override
    public void setSalary(Salary salary) {
        System.out.println("[COOK]: My salary could be better");
    }

}
