package com.java8.chapter2;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 2017/9/4.
 */
public class Parameterization {

    @Data
    public static class Apple {

        private int weight;
        private String color;

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

    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    public static class AppleHeavyWeightPredicate implements ApplePredicate {

        public boolean test(Apple apple) {
            return apple.getWeight() > 100;
        }
    }

    public static class AppleGreenColorPredicate implements ApplePredicate {

        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {

        List<T> result = new ArrayList<>();
        for (T e: list) {
            if(p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

//        List<Apple> result = filterApple(inventory, new AppleGreenColorPredicate());
//        List<Apple> result = filterApple(inventory, new AppleHeavyWeightPredicate());

        //使用匿名类来优化代码，当然前提是这个只需要用一次，在系统中不会被复用，如果会被复用的话最好还是把具体的实现类写出来，在java的API中就有
        //很多这样的例子，比如ThreadPool
//        List<Apple> result = filterApple(inventory, new ApplePredicate() {
//            @Override
//            public boolean test(Apple apple) {
//                return apple.getWeight() > 0;
//            }
//        });

//        List<Apple> result = filterApple(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Apple> result = filter(inventory, (Apple apple) -> "green".equals(apple.getColor()));

        System.out.println(result);
    }
}
