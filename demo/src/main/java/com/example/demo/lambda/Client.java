package com.example.demo.lambda;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
    }
    public static String implement(Doable doable, String first, String second) {
        return doable.doImplementation(first, second);
    }
    public static Doable doUpperCase(){
        return (f, i) -> f.toUpperCase() + " " + i.toUpperCase();
    }
}
