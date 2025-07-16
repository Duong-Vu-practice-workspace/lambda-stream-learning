package com.example.demo.stream.comparing;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ComparingStream {
    public static void main(String[] args) {
        Student a = new Student("A", "1", 3.5);
        Student b = new Student("B", "2", 3.0);
        Student c = new Student("C", "3", 3.6);

        Optional<Student> op = Stream.of(a, b, c).min(Comparator.comparing(s -> s.getGpa()).reversed());
        System.out.println(op.get());

    }
}
