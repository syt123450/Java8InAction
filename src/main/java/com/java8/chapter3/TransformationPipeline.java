package com.java8.chapter3;

import java.util.function.Function;

/**
 * Created by ss on 2017/9/5.
 */
public class TransformationPipeline {

    public static class Letter {

        public static String addHeader(String text) {
            return "header: " + text;
        }

        public static String addFooter(String text) {
            return text + "/footer";
        }

        public static String changeCase(String text) {
            return text.toLowerCase();
        }
    }

    public static void main(String[] args) {

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> pipeLine = addHeader.andThen(Letter::changeCase).andThen(Letter::addFooter);
        System.out.println(pipeLine.apply("Hello World!"));
    }
}
