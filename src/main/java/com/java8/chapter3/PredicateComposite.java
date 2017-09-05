package com.java8.chapter3;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ss on 2017/9/5.
 */
public class PredicateComposite {

    @Data
    public static class Apple {

        private Integer weight;
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

    public static <E> List<E> filter(List<E> list, Predicate<E> predicate) {

        List<E> result = new ArrayList<E>();
        for (E e: list) {
            if(predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "green"));

        Predicate<Apple> redApplePredicate = (a) -> a.getColor().equals("red");
        Predicate<Apple> notRedApplePredicate = redApplePredicate.negate();
        Predicate<Apple> nonePredicate = redApplePredicate.and(notRedApplePredicate);
        Predicate<Apple> allPredicate = redApplePredicate.or(notRedApplePredicate);

        List<Apple> result = filter(inventory, allPredicate);

        System.out.println(result);
    }
}
