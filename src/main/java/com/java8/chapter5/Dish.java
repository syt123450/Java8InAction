package com.java8.chapter5;

import lombok.Getter;

/**
 * Created by ss on 2017/9/5.
 */

@Getter
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public enum Type {MEAT, FISH, OTHER}
}
