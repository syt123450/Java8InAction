package com.java8.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by ss on 2017/9/5.
 */
public class FunctionDemo {

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {

        List<R> result = new ArrayList<R>();
        for (T e: list) {
            result.add(function.apply(e));
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("112", "", "34567");
        List<Integer> result = map(stringList, (String s) -> s.length());
        System.out.println(result);
    }
}
