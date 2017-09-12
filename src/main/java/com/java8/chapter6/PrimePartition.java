package com.java8.chapter6;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

/**
 * Created by ss on 2017/9/10.
 */
public class PrimePartition {

    public static boolean isPrime(int n) {

        int nRoot = (int) Math.sqrt(n);
        return IntStream.rangeClosed(2, nRoot).noneMatch(i -> n % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrime(int n) {

        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(PrimePartition::isPrime));
    }

    public static void main(String[] args) {

        System.out.println(partitionPrime(13));
    }
}
