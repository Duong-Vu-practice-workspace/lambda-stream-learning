package com.example.demo.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.*;

public class Client {
    public static void main(String[] args) {
        String first = "Hello";
        String second = "World!";
        System.out.println(implement((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), first, second));

        System.out.println(doUpperCase().doImplementation("Hello", "lambda"));

        Flyable a = Objects::isNull;
        System.out.println(a.isUppercase("b"));

        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());

        Consumer<String> consumer = (s -> {
            System.out.println("Hello 1: " + s);
        });
        Consumer<String> consumer1 = (s -> {
            System.out.println("String value: " + s);
        });
        Consumer<String> totalConsumer = consumer.andThen(consumer1);
        totalConsumer.accept("consumer");

        // BiConsumer
        BiConsumer<String, String> biConsumer = (f, s) -> {
            System.out.println("My name is: " + f);
            System.out.println("My address is " + s);
        };
        biConsumer.accept("Duong", "Hanoi");

        Map<String, String> map = new HashMap<>();
        map.put("1", "Duong");
        map.put("2", "Nam");
        map.put("3", "Duy");
        map.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));

        Predicate<Integer> predicate1 = n -> n > 3;
        Predicate<Integer> predicate2 = n -> n < 10;
        System.out.println(predicate1.and(predicate2).test(4));

        // function
        Function<Integer, Boolean> lessThan5 = i -> i < 5;
        Function<Boolean, String> printBoolean = b -> b.toString();

        System.out.println(lessThan5.andThen(printBoolean).apply(3));
        System.out.println(lessThan5.andThen(printBoolean).apply(6));
    }
    public static String implement(Doable doable, String first, String second) {
        return doable.doImplementation(first, second);
    }
    public static Doable doUpperCase(){
        return (f, i) -> f.toUpperCase() + " " + i.toUpperCase();
    }
}
