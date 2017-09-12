package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 2017/9/6.
 */
public class StreamMatchDemo {

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

        if (menu.stream().anyMatch(dish -> dish.getName().equals("pork"))) {
            System.out.println("exist pork");
        }

        if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("low calories menu");
        }

        if (menu.stream().noneMatch(dish -> dish.getName().equals("XXX"))) {
            System.out.println("no XXX");
        }
    }
}
