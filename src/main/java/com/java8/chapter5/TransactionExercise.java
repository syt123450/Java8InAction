package com.java8.chapter5;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ss on 2017/9/6.
 */
public class TransactionExercise {

    @Getter
    public static class Trader {

        private final String name;
        private final String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Trader: " + name + " in " + city;
        }
    }

    @Getter
    public static class Transaction {

        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + trader + ", " + year + ", " + value + "}";
        }
    }

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年发生的交易，并按交易额从低到高排序
//        List<Transaction> transactions2011 = transactions.stream()
//                .filter(transaction -> transaction.getYear() == 2011)
//                .sorted(Comparator.comparing(Transaction::getValue))
//                .collect(Collectors.toList());
//        System.out.println(transactions2011);

        //交易员倒在乃些不同的城市工作过
//        List<String> cities = transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .distinct()
//                .collect(Collectors.toList());
        //使用toSet可以转化成set，根据set的性质，会自动删掉重复的值，不需要手动使用distinct了
//        Set<String> cities = transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .collect(Collectors.toSet());
//        System.out.println(cities);

        //查找所有来自剑桥的交易员，并按姓名排序
//        List<Trader> traders = transactions.stream()
//                .map(Transaction::getTrader)
//                .distinct()
//                .filter(trader -> trader.getCity().equals("Cambridge"))
//                .sorted(Comparator.comparing(Trader::getName))
//                .collect(Collectors.toList());
//        System.out.println(traders);

        //返回所有交易员的姓名字符串，按字母顺序排序
//        List<String> names = transactions.stream()
//                .map(transaction -> transaction.getTrader().getName())
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(names);

        //这种方法效率不高，因为在reduce中，字符串不断拼接，会产生很多中间对象
//        String traderStr = transactions.stream()
//                .map(transaction -> transaction.getTrader().getName())
//                .distinct()
//                .sorted()
//                .reduce("", (a, b) -> a + b);
//        System.out.println(traderStr);

        //这里使用了StringBuilder,更加高效
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(traderStr);

        //有没有交易员是在米兰工作的
//        boolean inMilanOrNot = transactions.stream()
//                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
//        System.out.println(inMilanOrNot);


        //打印生活在剑桥的交易员的所有交易额
//        transactions.stream()
//                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
//                .forEach(System.out::println);

        //所有交易中，最高的交易额是多少
//        Optional<Integer> max = transactions.stream()
//                .map(transaction -> transaction.getValue())
//                .reduce(Integer::max);
//        max.ifPresent(System.out::println);

        //找到交易额最小的交易
//        Optional<Transaction> minTransaction = transactions.stream()
//                .reduce((transaction1, transaction2)
//                        -> transaction1.getValue() < transaction2.getValue() ? transaction1 : transaction2);
//        minTransaction.ifPresent(System.out::println);
        //流支持min和max，输入一个comparator就可以了
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        minTransaction.ifPresent(System.out::println);

    }
}
