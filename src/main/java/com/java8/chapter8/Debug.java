package com.java8.chapter8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 2017/9/13.
 */
public class Debug {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(2, 3, 4, 5);

        integerList.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(1)
                .forEach(System.out::println);

        integerList.stream()
                .peek(x -> System.out.println("from stream " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map " + x))
                .filter(x -> x % 2 == 0)
                .limit(2)
                .forEach(System.out::println);
    }
}
