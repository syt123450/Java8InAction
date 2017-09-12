package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/6.
 */
public class LimitAndSkip {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 4);

        List<Integer> limit3 = numbers.stream().limit(3).collect(Collectors.toList());
        System.out.println(limit3);

        List<Integer> skip3 = numbers.stream().skip(3).collect(Collectors.toList());
        System.out.println(skip3);
    }
}
