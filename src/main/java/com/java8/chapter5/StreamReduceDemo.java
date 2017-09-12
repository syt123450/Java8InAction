package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by ss on 2017/9/6.
 */
public class StreamReduceDemo {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5};
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println(sum);

        //从基本类型的array转化而来的流默认是基本类型的流，如果需要变成Integer类型的流需要boxed()
        Optional<Integer> sumOptional = Arrays.stream(numbers).boxed().reduce(Integer::sum);
//        Optional<Integer> sumOptional = numberList.stream().reduce(Integer::sum);
        sumOptional.ifPresent(System.out::println);

        Optional<Integer> max = numberList.stream().reduce(Integer::max);
        max.ifPresent(System.out::println);

    }
}
