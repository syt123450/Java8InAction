package com.java8.chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by ss on 2017/9/19.
 */
public class ExchangeService {

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static double getRate() {

        delay();
        return 1.2;
    }

    public static void main(String[] args) throws Exception {

        Shop shop = new Shop("111");
        String product = "333";

        Future<Double> futurePrices =
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                        CompletableFuture.supplyAsync(
                                () -> ExchangeService.getRate()
                        ),
                        (price, rate) -> price * rate
                );

        System.out.println(futurePrices.get());

    }
}
