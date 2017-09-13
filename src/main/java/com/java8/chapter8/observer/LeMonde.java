package com.java8.chapter8.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ss on 2017/9/13.
 */
public class LeMonde implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Feed feed = (Feed) o;
        if (feed.getNews() != null && feed.getNews().contains("wine")) {
            System.out.println("Today cheese, wine and news! " + feed.getNews());
        }
    }
}
