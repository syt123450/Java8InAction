package com.java8.chapter11;

import lombok.Getter;

/**
 * Created by ss on 2017/9/19.
 */
public class Quote {

    @Getter
    private final String shopName;
    @Getter
    private final double price;
    @Getter
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {

        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s) {

        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);

        return new Quote(shopName, price, discountCode);
    }
}
