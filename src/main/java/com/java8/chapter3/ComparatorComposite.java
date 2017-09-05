package com.java8.chapter3;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ss on 2017/9/5.
 */
public class ComparatorComposite {

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

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "green"));

        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor).reversed());
        System.out.println(inventory);
    }
}
