package streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        defaultFunctionalJavaInterfaces();
        //functionalInterfacesExcercise();
    }

    private static void defaultFunctionalJavaInterfaces() {
        // Predicate - checking some condition
        Predicate<Integer> predicate = t -> t.compareTo(Integer.valueOf(20)) > 0;
        int value = 9;
        int value2 = 21;
        System.out.println(String.format("PREDICATE: for %s = %s", value, predicate.test(value)));
        System.out.println(String.format("PREDICATE: for %s = %s", value2, predicate.test(value2)));

        // Supplier - factory
        Supplier<Double> supplier = () -> Math.random() * 10;
        System.out.println(String.format("SUPPLIER: %s", supplier.get()));

        // Consumer
        Consumer<String> consumer = t -> System.out.println("CONSUMER: " + t);
        consumer.accept("test");

        // Function - change one type to another
        Function<Integer, String> function = t -> { String header = "FUNCTION: ";
                                                    return t.compareTo(1) > 0 ? header + "YES" : header + "NO";
                                                  };
        System.out.println(function.apply(0));
    }

    private static void functionalInterfacesExcercise() {

        VoidInterface voidInterface = t -> System.out.println(t);
        voidInterface.test("Kamil test");
        VoidInterface voidInterface2 = t -> System.out.println(t + " another impl");
        voidInterface2.test("Kamil test");

        StringInterface stringInterface = t -> t.replaceAll("t", "");
        System.out.println(stringInterface.test("String with cut out letters"));

        IntToStringInterface intToStringInterface = i -> i == 1 ? "One" : "Not one";
        System.out.println(intToStringInterface.test(1));
        System.out.println(intToStringInterface.test(2));

        System.out.println(predicateMethod(t -> t.equals("test"), "test"));
        System.out.println(predicateMethod(t -> t.equals("test"), "nottest"));

    }

    private static boolean predicateMethod(Predicate<String> predicate, String text) {
        return predicate.test(text);
    }

}
