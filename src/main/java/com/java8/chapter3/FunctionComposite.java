package com.java8.chapter3;

import java.util.function.Function;

/**
 * Created by ss on 2017/9/5.
 */
public class FunctionComposite {

    public static void main(String[] args) {

        Function<Integer, Integer> f = (x) -> x + 1;
        Function<Integer, Integer> g = (x) -> 2 * x;

        Function<Integer, Integer> andThen = f.andThen(g);
        System.out.println(andThen.apply(1));

        Function<Integer, Integer> compose = f.compose(g);
        System.out.println(compose.apply(1));

    }
}
