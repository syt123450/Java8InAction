package com.java8.chapter9;

/**
 * Created by ss on 2017/9/14.
 */
public class DefaultProblem {

    private static interface A {

        default void hello() {
            System.out.println("Hello A.");
        }
    }

    private static interface B extends A {

        @Override
        default void hello() {
            System.out.println("Hello B.");
        }
    }

    private static class C implements B {

    }

    public static void main(String[] args) {

        C c = new C();
        c.hello();
    }
}
