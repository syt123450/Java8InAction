package com.java8.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/7.
 */
public class Sum {

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

        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        int sum1 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(sum1);

        int sum2 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(sum2);

        int sum3 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum3);
    }
}
