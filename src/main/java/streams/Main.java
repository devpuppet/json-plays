package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //defaultFunctionalJavaInterfaces();
        //functionalInterfacesExcercise();
        streamsExcercies();
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

    private static void streamsExcercies() {

        Consumer<Person> print = t -> System.out.println(String.format("Name: %s, age: %s",
                t.getName(), t.getAge()));

        System.out.println("--- Print all Persons ---");
        createPersonsList().stream().forEach(print);

        System.out.println("--- Filter and print all Persons above or equal 27 ---");
        createPersonsList().stream().filter(t -> t.getAge() >= 27).forEach(print);

        System.out.println("--- Stream without terminal operation (intermediate operations not invoked )---");
        createPersonsList().stream().filter(t -> {
                System.out.println("EXECUTING FILTER");
                return t.getAge() > 20;
        });

        System.out.println("--- Int Streams (of primitives and objects) ---");
        System.out.println("Average: " + IntStream.range(0,5).average());
        IntStream.range(0,5).forEach(t -> System.out.println(t + " - simple int"));
        Stream.of(1,2,3,4).forEach(t -> System.out.println(t + " - " + t.getClass().getSimpleName()));

        System.out.println("--- Sorting lists (peek for intermediate operation) ---");
        createPersonsList().stream()
                .peek(print)
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(print);

        System.out.println("--- flatMap - change nested collections to one collection ---");
        createPersonsList().stream().flatMap(t -> Arrays.asList(t, "test").stream())
                .forEach(t -> { if (t instanceof Person) System.out.println(((Person) t).getName());
                                else System.out.println(t);
                });

        List<Object> flattenedList = createPersonsList().stream().flatMap(t -> Arrays.asList(t, "test").stream())
                .collect(Collectors.toList());

    }

    private static List<Person> createPersonsList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Kamil", 28));
        list.add(new Person("Sara", 27));
        list.add(new Person("Aneta", 31));
        list.add(new Person("Paweł", 12));

        return list;
    }

}
