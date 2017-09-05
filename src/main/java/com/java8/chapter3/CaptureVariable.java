package com.java8.chapter3;

/**
 * Created by ss on 2017/9/5.
 */
public class CaptureVariable {

    public static void main(String[] args) {

        int portNumber = 111;

        Runnable runnable = () -> System.out.println(portNumber);

        runnable.run();
    }
}
