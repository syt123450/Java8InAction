package com.java8.chapter3;

import com.java8.chapter2.Sort;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ss on 2017/9/5.
 */

//multiple ways to sort list
public class SortApple {

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

    public static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple apple1, Apple apple2) {
            return apple1.getWeight().compareTo(apple2.getWeight());
        }
    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        //override comparator to sort inventory
//        inventory.sort(new AppleComparator());
//        System.out.println(inventory);


        //use anonymous class to override comparator
//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
//        System.out.println(inventory);

        //use lambda to replace anonymous class
//        inventory.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
//        System.out.println(inventory);

        //Comparator has a static function comparing(), it can accept Function to extract Comparable value,
        //then return a Comparator
//        inventory.sort(Comparator.comparing((a) -> a.getWeight()));
//        System.out.println(inventory);

        //Function reference
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }
}
