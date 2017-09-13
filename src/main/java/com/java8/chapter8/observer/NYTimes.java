package com.java8.chapter8.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ss on 2017/9/13.
 */

//java中观察者实现Observer接口
public class NYTimes implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Feed feed = (Feed) o;
        if (feed.getNews() != null && feed.getNews().contains("money")) {
            System.out.println("Breaking news in NY! " + feed.getNews());
        }
    }
}
