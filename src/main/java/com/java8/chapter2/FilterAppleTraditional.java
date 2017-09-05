package com.java8.chapter2;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 2017/9/4.
 */
public class FilterAppleTraditional {

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

    public static List<Apple> filterGreenApple(List<Apple> inventory) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if(color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String ... args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

//        List<Apple> result = filterGreenApple(inventory);
//        List<Apple> result = filterAppleByColor(inventory, "red");
        List<Apple> result = filterAppleByWeight(inventory, 10);

        System.out.println(result);
    }
}
