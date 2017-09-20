package com.java8.chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ss on 2017/9/19.
 */
public class Completion {

    public static Stream<CompletableFuture<String>> findPricesStream(List<Shop> shops, String product) {

        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getDiscountPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                    CompletableFuture.supplyAsync(
                            () -> Discount.applyDiscountRandom(quote)
                    )
                ));
    }

    public static void main(String[] args) throws Exception {

        List<Shop> shops = Arrays.asList(
                new Shop("111"),
                new Shop("222"),
                new Shop("333"),
                new Shop("444"));

        CompletableFuture[] futures = findPricesStream(shops, "kkk")
                .map(future -> future.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();
    }
}
