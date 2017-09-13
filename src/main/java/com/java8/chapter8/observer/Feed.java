package com.java8.chapter8.observer;

import java.util.Observable;

/**
 * Created by ss on 2017/9/13.
 */

//在java中被观察者是Observable的子类
public class Feed extends Observable {

    private String news;

    public String getNews() {
        return this.news;
    }

    public void setNews(String news) {
        this.news = news;
        //setChanged()之后会标记内部变化了，然后才会通知所有的Observers,不设置就不会通知
        setChanged();
        notifyObservers();
    }
}
