package com.java8.chapter9;

/**
 * Created by ss on 2017/9/14.
 */
public class DiamondProblem {

    private static interface A {

        default void hello() {
            System.out.println("Hello A.");
        }
    }

    private static interface B extends A {

//        @Override
//        default void hello() {
//            System.out.println("Hello B.");
//        }
    }

    private static interface C extends B {

//        @Override
//        default void hello() {
//            System.out.println("Hello C.");
//        }
    }

    private static interface D extends A {

        @Override
        default void hello() {
            System.out.println("Hello D.");
        }
    }

    private static class E implements C, D {

//        @Override
//        public void hello() {
//            System.out.println("Hello E.");
//        }
    }

    public static void main(String[] args) {

        E e = new E();
        e.hello();
    }
}
