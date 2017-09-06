package com.java8.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/5.
 */
public class TraverseOnce {

    public static void main(String[] args) {

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stringStream = title.stream();
        stringStream.collect(Collectors.toList());

        //stream 不能被调用第二次，一个流只能被消费一次
//        stringStream.collect(Collectors.toList());
    }
}
