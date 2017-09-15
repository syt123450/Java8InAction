package com.java8.chapter10;

import java.util.Optional;

/**
 * Created by ss on 2017/9/15.
 */
public class OptionalFilter {

    public static void main(String[] args) {

        Optional<Insurance> insurance = Optional.of(new Insurance());
        insurance.filter(insurance1 -> "cam".equals(insurance1.getName()))
                .ifPresent(System.out::println);
    }
}
