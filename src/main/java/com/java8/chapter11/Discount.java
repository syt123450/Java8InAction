package com.java8.chapter11;

import java.util.Random;

/**
 * Created by ss on 2017/9/19.
 */
public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {

        return quote.getShopName() + " price is "
                + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    public static String applyDiscountRandom(Quote quote) {
        return quote.getShopName() + " price is "
                + Discount.applyRandom(quote.getPrice(), quote.getDiscountCode());

    }

    public static double apply(double price, Code code) {

        delay();
        return price * (100 - code.percentage) / 100;
    }

    public static double applyRandom(double price, Code code) {

        randomDelay();
        return price * (100 - code.percentage) / 100;
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final Random random = new Random();

    public static void randomDelay() {

        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
