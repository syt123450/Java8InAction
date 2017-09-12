package com.java8.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/6.
 */
public class PythagoreamTheorem {

    public static void main(String[] args) {

//        Stream<int[]> triple = IntStream
//                .rangeClosed(1, 100)
//                .boxed()
//                .flatMap(a ->
//                        IntStream.rangeClosed(a, 100)
//                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
//                );
//
//        triple.forEach(array -> System.out.println(Arrays.toString(array)));

        Stream<double[]> triples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(triple -> triple[2] % 2 == 1)
                );

        triples.map(Arrays::toString).forEach(System.out::println);
    }
}
