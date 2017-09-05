package com.java8.chapter3;

/**
 * Created by ss on 2017/9/4.
 */
public class Syntax {

    public static void process(Runnable runnable) {
        runnable.run();
    }

    public static void main(String[] args) {
        Runnable runnable1 = () -> System.out.println("Run 1.");
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run 2.");
            }
        };

        process(runnable1);
        process(runnable2);
        process(() -> System.out.println("Run 3."));
    }
}
