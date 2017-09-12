package com.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/6.
 */
public class DistinctWord {

    public static void main(String[] args) {

        List<String> wordList = Arrays.asList("Hello", "World");

        //转换出的的是是数字的一个list，不是String的list,使用""分割可以把String中的character一个一个分开
//        List<String[]> characterList = wordList.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .collect(Collectors.toList());

        //flatMap中的lambda方法需要返回一个流，这样flatMap方法才能把所有的流连接起来
        List<String> characterList = wordList.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(characterList);
    }
}
