package com.example.demo.stream.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamReduce {
    public static void main(String[] args) {
        // sum of list using reduce
        //bad way because converting between primitive types and wrapper object and vice versa
        List<Integer> a = new ArrayList<>();
        Collections.addAll(a, 1,2,3,4,5,6,7,8,9);
        Optional<Integer> result = a.stream().reduce((c, b) -> {
            System.out.println(c + " + " + b);
            return c + b;
        });
        System.out.println(result.get());

        //good way - using IntStream
        int sum = a.stream().mapToInt(b -> b).sum();
        System.out.println(sum);
        LongStream longStream = a.stream().mapToLong(b -> b);
        IntStream intStream = longStream.mapToInt(b -> (int)b);
        //back to stream
        Stream<Integer> boxed = intStream.boxed();

        IntStream.range(1, 10).forEach(t -> System.out.println("Hello world ! " + t));
        a.stream().tak
    }
}
