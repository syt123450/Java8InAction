package com.java8.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/16.
 */
public class SearchList {

    public static List<String> findPrice(List<Shop> shops, String product) {

        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());

    }

    public static List<String> findPriceAsync(List<Shop> shops, String product) {

        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> completableFutureExecutor(List<Shop> shops, String product) {

        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() ->
                                String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), executor))
                .collect(Collectors.toList());

        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    public static List<String> findPriceUsingCompletableFuture(List<Shop> shops, String product) {

        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() ->
                                String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());

        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private static final Executor executor =
            Executors.newFixedThreadPool(100, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {

                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                }
            });

    public static void main(String[] args) {

        List<Shop> shops = Arrays.asList(
                new Shop("111"),
                new Shop("222"),
                new Shop("333"),
                new Shop("444"));


        long startTime = System.currentTimeMillis();

        //get prices serially
//        System.out.println(findPrice(shops, "product"));

        //get prices asynchronized
//        System.out.println(findPriceAsync(shops, "product"));

        //使用completableFuture和parallelStream差不多，稍微多了几毫秒
        System.out.println(findPriceUsingCompletableFuture(shops, "product"));


        System.out.println("Query time is: " + (System.currentTimeMillis() - startTime));

    }
}
