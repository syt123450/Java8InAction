package com.java8.chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/19.
 */
public class DiscountService {

    private static final Executor executor =
            Executors.newFixedThreadPool(100, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {

                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                }
            });

    public static List<String> findPrices(List<Shop> shops, String product) {

        return shops.stream()
                .map(shop -> shop.getDiscountPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPricesCompletableFuture(List<Shop> shops, String product) {

        List<CompletableFuture<String>> pricesFuture =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getDiscountPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                    CompletableFuture.supplyAsync(
                            () -> Discount.applyDiscount(quote), executor
                    )))
                .collect(Collectors.toList());

        return pricesFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Shop> shops = Arrays.asList(
                new Shop("111"),
                new Shop("222"),
                new Shop("333"),
                new Shop("444"));

        long startTime = System.currentTimeMillis();
//        System.out.println(findPrices(shops, "edc"));

        System.out.println(findPricesCompletableFuture(shops, "edc"));

        System.out.println("Execute time is: " + (System.currentTimeMillis() - startTime));
    }
}
