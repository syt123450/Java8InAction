package com.java8.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by ss on 2017/9/5.
 */
public class ConsumerDemo {

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {

        for (T e: list) {
            consumer.accept(e);
        }
    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        forEach(integerList, (Integer i) -> System.out.println(i + 1));
    }
}
