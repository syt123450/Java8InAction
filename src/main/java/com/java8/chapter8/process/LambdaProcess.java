package com.java8.chapter8.process;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by ss on 2017/9/13.
 */
public class LambdaProcess {

    public static void main(String[] args) {

        UnaryOperator<String> headerProcess = (s -> "Head: " + s);
        UnaryOperator<String> tailProcess = (s -> s + "/tail");

        Function<String, String> pipeLine = headerProcess.andThen(tailProcess);

        System.out.println(pipeLine.apply("content"));
    }
}
