package com.java8.chapter10;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Created by ss on 2017/9/14.
 */
public class Person {

    private Optional<Car> car = Optional.empty();

    public Optional<Car> getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = Optional.of(car);
    }
}
