package com.java8.chapter3;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by ss on 2017/9/5.
 */
public class ConstructRefDemo {

    @Data
    public static class Apple {

        private Integer weight;
        private String color;

        public Apple() {}

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public Apple(int weight, String color) {

            this.weight = weight;
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> function) {

        List<Apple> result = new ArrayList<>();
        for(Integer integer: list) {
            result.add(function.apply(integer));
        }

        return result;
    }

    public static void main(String[] args) {

//        Supplier<Apple> supplier = Apple::new;
//        Apple apple = supplier.get();

//        Supplier<Apple> supplier = () -> new Apple();

//        Function<Integer, Apple> supplier = Apple::new;
//        Apple apple = supplier.apply(1);

//        Function<Integer, Apple> supplier = (i) -> new Apple(i);

//        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
//        List<Apple> apples = map(integerList, Apple::new);
//        System.out.println(apples);

//        BiFunction<Integer, String, Apple> biFunction = Apple::new;
//        Apple apple = biFunction.apply(120, "green");
//        System.out.println(apple);

        BiFunction<Integer, String, Apple> biFunction = (weight, color) -> new Apple(weight, color);

    }
}
