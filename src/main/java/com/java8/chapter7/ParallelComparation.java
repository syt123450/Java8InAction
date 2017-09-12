package com.java8.chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/11.
 */
public class ParallelComparation {

    public static long streamParallelComputing(long n) {

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long streamSequentialComputing(long n) {

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        return sum;
    }

    public static long longStreamParallelComputing(long n) {

        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0, Long::sum);
    }

    public static long longStreamSequentialComputing(long n) {

        return LongStream.rangeClosed(1, n)
                .reduce(0, Long::sum);
    }

    public static long measure(Function<Long, Long> adder, long n) {

        long total = 0;
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            adder.apply(n);
            long end = System.currentTimeMillis();
            long time = end - start;
            total += time;
        }

        return total;
    }


    //测试结果是在1000000时是iterative快，但是到了100000000时，并行就快乐
    public static void main(String[] args) {

//        System.out.println("Stream Parallel time:");
//        System.out.println(measure(ParallelComparation::streamParallelComputing, 100000000));
//
//        System.out.println("Stream Sequential time:");
//        System.out.println(measure(ParallelComparation::streamSequentialComputing, 100000000));

        System.out.println("Iterative time:");
        System.out.println(measure(ParallelComparation::iterativeSum, 100000000));

        System.out.println("LongStream Parallel time:");
        System.out.println(measure(ParallelComparation::longStreamParallelComputing, 100000000));

        System.out.println("LongStream Sequential time:");
        System.out.println(measure(ParallelComparation::longStreamSequentialComputing, 100000000));

    }
}
