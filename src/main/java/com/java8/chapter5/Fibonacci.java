package com.java8.chapter5;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/7.
 */
public class Fibonacci {

    public static void printFromIterate() {

        Stream.iterate(new int[]{1, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .map(ints -> ints[0])
                .limit(10)
                .forEach(System.out::println);
    }

    public static void printFromGenerate() {

        IntStream.generate(new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int tmp = previous;
                previous = current;
                current += tmp;
                return previous;
            }
        }).limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {

        printFromIterate();

        System.out.println("======");

        printFromGenerate();
    }
}
