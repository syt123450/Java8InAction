package com.java8.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/10.
 */
public class CollectAndReduce {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5).stream();
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);

        List<Integer> result = stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer i) -> {
            l.add(i);
            return l;
        }, (List<Integer> l1, List<Integer> l2) -> {l1.addAll(l2); return l1;});

        System.out.println(result);
    }
}
