package com.java8.chapter2;

/**
 * Created by ss on 2017/9/4.
 */
public class Run {

    public static void main(String[] args) {

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Run thread.");
//            }
//        });

        Thread thread = new Thread(() -> System.out.println("Run Thread."));

        thread.start();
    }
}
