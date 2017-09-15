package com.java8.chapter10;

import java.util.Optional;
import java.util.Properties;

/**
 * Created by ss on 2017/9/15.
 */
public class ActualUse {

    private static Optional<Integer> stringToInt(String s) {

        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static int readDuration(Properties properties, String name) {

        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(ActualUse::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-3");

        System.out.println(readDuration(properties, "a"));
    }
}
