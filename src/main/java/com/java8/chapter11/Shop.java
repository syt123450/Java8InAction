package com.java8.chapter11;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by ss on 2017/9/15.
 */
public class Shop {

    @Getter
    private final String name;

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {

        return calculatePrice(product);
    }

    public String getDiscountPrice(String product) {

        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private static void delay() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static double calculatePrice(String product) {

        delay();
//        if (product.equals("111")) {
//            Random random = new Random();
//            double price =  random.nextDouble() * product.charAt(0) + product.charAt(1);
//            return price;
//        } else {
//            throw new Exception("do not have such product.");
//        }

        Random random = new Random();
        double price =  random.nextDouble() * product.charAt(0) + product.charAt(1);
        return price;
    }

    public static Future<Double> getPriceAsync(String product) {

        CompletableFuture<Double> future = new CompletableFuture<>();

        //without error handle
//        new Thread(() -> {
//            double price = calculatePrice(product);
//            future.complete(price);
//        }).start();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();

        return future;
    }

//    public static Future<Double> getPriceAsync2(String product) {
//
//        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//    }

    public static void main(String[] args) {

//        long startTime = System.currentTimeMillis();
//        getPrice("111");
//        System.out.println(System.currentTimeMillis() - startTime);

        long startTime = System.currentTimeMillis();
        Future<Double> futurePrice = getPriceAsync("Hello");
        System.out.println("Invocation return time: " + (System.currentTimeMillis() - startTime));

        try {
            double price = futurePrice.get();
            System.out.println("Price is: " + price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Price return time: " + (System.currentTimeMillis() - startTime));
    }
}
