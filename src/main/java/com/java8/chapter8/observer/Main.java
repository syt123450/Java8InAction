package com.java8.chapter8.observer;

/**
 * Created by ss on 2017/9/13.
 */
public class Main {

    public static void main(String[] args) {

        Feed feed = new Feed();
        feed.addObserver(new NYTimes());
        feed.addObserver(new LeMonde());
        feed.setNews("wine and wine");
        feed.setNews("money money");
        feed.setNews("wine and money");
    }
}
