package com.java8.chapter8.process;

/**
 * Created by ss on 2017/9/13.
 */
public class Client {

    public static void main(String[] args) {

        ProcessingObject<String> process1 = new HeadProcessing();
        ProcessingObject<String> process2 = new TailProcessing();

        process1.setSuccessor(process2);

        System.out.println(process1.handle("content"));
    }
}
