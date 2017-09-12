package com.java8.chapter5;

import sun.jvmstat.perfdata.monitor.protocol.file.FileMonitoredVm;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/6.
 */
public class CreateStream {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("Hello", "World");
        stringStream.map(String::toLowerCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream.count());

        int[] numbers = new int[]{1, 2, 3, 4};
        IntStream streamFromIntArray = Arrays.stream(numbers);

        Integer[] numbers2 = new Integer[]{1, 2, 3, 4, 5};
        Stream<Integer> streamFromIntegerArray = Arrays.stream(numbers2);

        long uniqueWords = 0;
        try {
            Stream<String> lines = Files.lines(Paths.get("/tmp/data.txt"));
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println(uniqueWords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
