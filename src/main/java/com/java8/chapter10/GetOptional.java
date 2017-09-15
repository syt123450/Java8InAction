package com.java8.chapter10;

import java.util.Optional;

/**
 * Created by ss on 2017/9/15.
 */
public class GetOptional {

    public static void main(String[] args) {

        Optional<Person> person = Optional.of(new Person());
        Optional<Car> car = person.get().getCar();

        //car为Optional.empty,无法get值，会出NoSuchElementException
//        car.get();

        Car carInstance = car.orElse(new Car());

        //当创建默认值比较耗时费力的时候使用
        Car car1 = car.orElseGet(Car::new);

        try {
            //当没有值时抛出异常
            Car car2 = car.orElseThrow(() -> new Exception());
        } catch (Exception e) {

        }

        car.ifPresent(System.out::println);
    }
}
