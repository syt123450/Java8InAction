package com.java8.chapter8.process;

/**
 * Created by ss on 2017/9/13.
 */
public class HeadProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWord(String input) {
        return "Head: " + input;
    }
}
