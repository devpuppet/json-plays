package spring.exercise_classes.aspect;

import spring.exercise_classes.designators.Salary;

public interface ICook {

    void getIngredients();
    void getIngredients(int amount);
    void preparePizza();
    void deliverPizza();
    void preparePasta();
    void addError(String error);
    void printErrors();
    void setSalary(Salary salary);

}
