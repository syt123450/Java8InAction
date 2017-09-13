package com.java8.chapter8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 2017/9/13.
 */
public class Debugging {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, null);
        integers.stream().map(Debugging::add).forEach(System.out::println);
    }

    private static int add(Integer integer) {
        return integer++;
    }
}
