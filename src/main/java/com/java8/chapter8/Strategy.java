package com.java8.chapter8;

/**
 * Created by ss on 2017/9/13.
 */
public class Strategy {

    private static interface ValidationStrategy {
        boolean execute(String s);
    }

    private static class IsAllLowerCase implements ValidationStrategy {

        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    private static class IsNumeric implements ValidationStrategy {

        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    private static class Validator {

        private final ValidationStrategy validationStrategy;

        public Validator(ValidationStrategy validationStrategy) {
            this.validationStrategy = validationStrategy;
        }

        public boolean validate(String s) {
            return validationStrategy.execute(s);
        }
    }

    public static void main(String[] args) {

//        Validator numericValidator = new Validator(new IsNumeric());
//        boolean result1 = numericValidator.validate("aaa");
//        System.out.println(result1);
//
//        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
//        boolean result2 = lowerCaseValidator.validate("bbbb");
//        System.out.println(result2);

        Validator validator1 = new Validator((s) -> s.matches("[a-z]+"));
        boolean result1 = validator1.validate("aaa");
        System.out.println(result1);

        Validator validator2 = new Validator((s) -> s.matches("\\d+"));
        boolean result2 = validator2.validate("bbbb");
        System.out.println(result2);
    }
}
