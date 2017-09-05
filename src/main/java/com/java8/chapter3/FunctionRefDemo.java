package com.java8.chapter3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 2017/9/5.
 */
public class FunctionRefDemo {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("a", "b", "A", "B");

//        stringList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
//        System.out.println(stringList);

        stringList.sort(String::compareToIgnoreCase);
        System.out.println(stringList);
    }
}
