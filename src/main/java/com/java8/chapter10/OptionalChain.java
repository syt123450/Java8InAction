package com.java8.chapter10;

import java.util.Optional;

/**
 * Created by ss on 2017/9/14.
 */
public class OptionalChain {

    public static void main(String[] args) {

        Optional<Person> person = Optional.of(new Person());

        String insuranceName = person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");

        System.out.println(insuranceName);
    }
}
