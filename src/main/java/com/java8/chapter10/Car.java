package com.java8.chapter10;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Created by ss on 2017/9/14.
 */
public class Car {

    //对于Optional的值，要显式赋值为Optional.empty(),类在初始化的时候默认还是null
    private Optional<Insurance> insurance = Optional.empty();

    public void setInsurance(Insurance insurance) {
        this.insurance = Optional.of(insurance);
    }

    public Optional<Insurance> getInsurance() {
        return this.insurance;
    }
}
