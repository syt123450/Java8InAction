package com.java8.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/7.
 */
public class MaxAndMin {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        Optional<Dish> maxDish = menu.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        maxDish.ifPresent(System.out::println);

        Optional<Dish> minDish = menu.stream()
                .min(Comparator.comparing(Dish::getCalories));
        minDish.ifPresent(System.out::println);
    }
}
