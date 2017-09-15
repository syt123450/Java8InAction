package com.java8.chapter10;

import java.util.Optional;

/**
 * Created by ss on 2017/9/14.
 */
public class CreateOptional {

    public static void main(String[] args) {

        //空对象Optional
        Optional<Car> carOptional = Optional.empty();
        //包含一个Car对象的Optional,此处包含的car对象不能是一个null
        Optional<Car> carOptional1 = Optional.of(new Car());

        Car car = new Car();
        car = null;
        Optional<Car> carOptional2 = Optional.ofNullable(car);
//        Optional<Car> carOptional3 = Optional.of(car);

    }
}
