package com.java8.chapter2;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ss on 2017/9/4.
 */
public class Sort {

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

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        //小于0表示不换，大于0表示交换位置
//        inventory.sort((Apple apple1, Apple apple2) -> apple1.getWeight() < apple2.getWeight() ? -1 : 1);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() < o2.getWeight() ? -1 : 1;
            }
        });

        System.out.println(inventory);
    }
}
