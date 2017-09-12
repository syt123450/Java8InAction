package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/6.
 */
public class StreamDistinct {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 4);
        List<Integer> evens = numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(evens);
    }
}
