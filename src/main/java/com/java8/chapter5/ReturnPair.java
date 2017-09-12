package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/6.
 */
public class ReturnPair {

    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);

        //如果两个流嵌套内部的流不需要转化成集合，因为结果到上层之后还需要转化成流，这样就多了一个转化过程
//        List<int[]> pairs = numbers1.stream()
//                .map(number -> numbers2.stream()
//                        .map(innerNumber -> new int[]{number, innerNumber})
//                        .collect(Collectors.toList()))
//                .flatMap(List::stream)
//                .collect(Collectors.toList());

//        List<int[]> pairs = numbers1.stream()
//                .flatMap(number -> numbers2.stream()
//                        .map(innerNumber -> new int[]{number, innerNumber}))
//                .collect(Collectors.toList());

        List<int[]> pairs = numbers1.stream()
                .flatMap(number -> numbers2.stream()
                        .filter(innerNumber -> (number + innerNumber) % 3 == 0)
                        .map(innerNumber -> new int[]{number, innerNumber}))
                .collect(Collectors.toList());

        pairs.stream().map(Arrays::toString).forEach(System.out::println);
    }
}
