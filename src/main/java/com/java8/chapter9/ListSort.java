package com.java8.chapter9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ss on 2017/9/13.
 */
public class ListSort {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 5, 1, 4);

        //sort是List的默认方法，naturalOrder是Comparator的静态方法
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
