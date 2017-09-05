package com.java8.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by ss on 2017/9/5.
 */
public class PredicateDemo {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("123", "", "456");

        Predicate<String> nonEmptyStringPredicate = (String string) -> !string.isEmpty();
        List<String> result = filter(stringList, nonEmptyStringPredicate);
        System.out.println(result);


        //test intPredicate, intPredicate函数接口中接受的是int类型，不会有装箱过程
        IntPredicate intPredicate = (int i) -> i > 0;
    }
}
