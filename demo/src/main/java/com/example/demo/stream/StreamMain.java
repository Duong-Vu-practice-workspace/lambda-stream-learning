package com.example.demo.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.add(11);
        a.add(12);
        a.add(13);

        a.stream().filter(i -> {
            System.out.println("filter -received " + i);
            return i % 2 == 0;
        })
                .map(i -> {
                    System.out.println("map - received " + i);
                    return i * i;
                })
                .forEach(s -> System.out.println(s));

        //flat map
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);

        ArrayList<Integer> c = new ArrayList<>();
        c.add(4);
        c.add(5);
        c.add(6);

        ArrayList<Integer> d = new ArrayList<>();
        d.add(7);
        d.add(8);
        d.add(9);

        List<List<Integer>> list = new ArrayList<>();
        list.add(b);
        list.add(c);
        list.add(d);

        list.stream()
                .flatMap(l -> l.stream())
                .map(i -> i * i)
                .forEach(l -> System.out.println(l));
    }
}
