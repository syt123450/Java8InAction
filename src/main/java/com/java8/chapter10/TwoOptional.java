package com.java8.chapter10;

import java.util.Optional;

/**
 * Created by ss on 2017/9/15.
 */
public class TwoOptional {

    public Insurance findCheapestInsurance(Car car, Person person) {

        return new Insurance();
    }

    //optional方法重载提供更多的使用选择
    public Optional<Insurance> findCheapestInsurance(Optional<Car> car, Optional<Person> person) {

//        if (car.isPresent() && person.isPresent()) {
//            return Optional.of(findCheapestInsurance(car.get(), person.get()));
//        } else {
//            return Optional.empty();
//        }
//
        return person.flatMap(p -> (car.map(c -> findCheapestInsurance(c, p))));
    }
}
