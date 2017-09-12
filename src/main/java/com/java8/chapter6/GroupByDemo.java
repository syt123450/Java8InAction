package com.java8.chapter6;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;

/**
 * Created by ss on 2017/9/10.
 */
public class GroupByDemo {

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

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

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishByCaloricLevel = menu.stream().collect(
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }
                        ));

        System.out.println(dishByCaloricLevel);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }))
                );

        System.out.println(dishByLevel);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricType = menu.stream().collect(
                groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories)))
        );

        System.out.println(mostCaloricType);

        Map<Dish.Type, Dish> mostCaloricType1 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)
                        )
                );

        System.out.println(mostCaloricType1);

        Map<Dish.Type, Integer> totalCaloric = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        System.out.println(totalCaloric);

//        Map<Dish.Type, Set<CaloricLevel>> caloricLevel =
//                menu.stream()
//                        .collect(groupingBy(Dish::getType,
//                                mapping(
//                                        dish -> {
//                                            if (dish.getCalories() <= 400) {
//                                                return CaloricLevel.DIET;
//                                            } else if (dish.getCalories() <= 700) {
//                                                return CaloricLevel.NORMAL;
//                                            } else {
//                                                return CaloricLevel.FAT;
//                                            }
//                                        }, toSet()
//
//                                ))
//                        );

        Map<Dish.Type, Set<CaloricLevel>> caloricLevel =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                mapping(
                                        dish -> {
                                            if (dish.getCalories() <= 400) {
                                                return CaloricLevel.DIET;
                                            } else if (dish.getCalories() <= 700) {
                                                return CaloricLevel.NORMAL;
                                            } else {
                                                return CaloricLevel.FAT;
                                            }
                                        }, toCollection(HashSet::new)

                                ))
                        );

        System.out.println(caloricLevel);
    }
}
