package com.java8.chapter7;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by ss on 2017/9/11.
 */
public class ParallelSum {

    public static Long sum(int n) {

        return LongStream.iterate(1L, L -> L + 1)
                .limit(n)
                .parallel()
                .reduce(0, Long::sum);
    }

    public static void main(String[] args) {

        System.out.println(sum(100));
    }
}
