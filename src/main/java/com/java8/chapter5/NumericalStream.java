package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/6.
 */
public class NumericalStream {

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

        //min和max必须要使用Optional,sum可以直接是int，因为sum有一个默认值是0
        OptionalInt totalCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .min();
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        //boxed()装箱操作可以使数值流转化成原始流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        //使用静态方法range可以生成范围内的数，rangeClosed包括最后一个数，range不包括
        IntStream rangeStream = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        System.out.println(rangeStream.count());
        System.out.println(IntStream.range(1, 100).filter(i -> i % 2 == 0).count());
    }
}
