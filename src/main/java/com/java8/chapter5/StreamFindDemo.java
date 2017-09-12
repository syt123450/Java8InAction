package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by ss on 2017/9/6.
 */
public class StreamFindDemo {

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

        Optional<Dish> anyDish = menu.stream()
                .filter(dish -> dish.getCalories()> 200)
                .findAny();
        anyDish.ifPresent(System.out::println);

        List<Integer> someNumber = Arrays.asList(1, 2, 3, 4, 5);
        someNumber.stream()
                .map(integer -> integer * integer)
                .filter(product -> product % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
