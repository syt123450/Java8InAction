package com.java8.chapter6;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created by ss on 2017/9/10.
 */
public class Partition {

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

        Map<Boolean, List<Dish>> partitionMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(partitionMenu);
        System.out.println(partitionMenu.get(true));

        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(vegetarianDishes);

        Map<Boolean, Map<Dish.Type, List<Dish>>> partitionAndGroupBy = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(partitionAndGroupBy);

        Map<Boolean, Dish> maxCaloricWithPartitioning = menu.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get
                )));

        System.out.println(maxCaloricWithPartitioning);
    }
}
