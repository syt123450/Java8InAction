package com.java8.chapter9;

/**
 * Created by ss on 2017/9/14.
 */
public class DefaultProblem2 {

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

    private static class D implements A {

        //如果D中没有覆盖那么会调用B的
//        @Override
//        public void hello() {
//            System.out.println("Hello D.");
//        }
    }

    private static class C extends D implements B {

    }

    public static void main(String[] args) {

        C c = new C();
        c.hello();
    }
}
