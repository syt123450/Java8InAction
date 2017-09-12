package com.java8.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/7.
 */
public class Joining {

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

        //直接joining不会有任何的分隔符，只是直接相连
        String names = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());

        System.out.println(names);

        String names1 = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));

        System.out.println(names1);
    }
}
