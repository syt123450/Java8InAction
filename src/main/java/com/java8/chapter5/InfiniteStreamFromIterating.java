package com.java8.chapter5;

import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/6.
 */
public class InfiniteStreamFromIterating {

    public static void main(String[] args) {

        //使用iterate创建无限流
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        //使用generate创建无限流
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
