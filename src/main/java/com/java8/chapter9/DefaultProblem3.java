package com.java8.chapter9;

/**
 * Created by ss on 2017/9/14.
 */
public class DefaultProblem3 {

    public static interface A {
        default void hello() {
            System.out.println("Hello A.");
        }
    }

    public static interface B {
        default void hello() {
            System.out.println("Hello B.");
        }
    }

    public static class C implements A, B {

        @Override
        public void hello() {
//            System.out.println("Hello C.");
            B.super.hello();
        }
    }

    public static void main(String[] args) {

        C c = new C();
        c.hello();
    }
}
