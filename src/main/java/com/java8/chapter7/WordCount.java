package com.java8.chapter7;

import java.text.ParseException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by ss on 2017/9/12.
 */
public class WordCount {

    public int countWordsIteratively(String s) {

        int counter = 0;
        boolean lastSpace = true;

        for (char c: s.toCharArray()) {

            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }

        return counter;
    }

    private static class WordCounter {

        private final int counter;
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {

            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(this.counter, true);
            } else {
                return lastSpace ? new WordCounter(this.counter + 1, false) : this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(this.counter + wordCounter.counter, false);
        }

        public int getCounter() {
            return this.counter;
        }
    }

    private int countWords(Stream<Character> stream) {

        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);

        return wordCounter.getCounter();
    }

    private static class WordCounterSpliterator implements Spliterator<Character> {


        private final String string;
        private int currentChar = 0;

        public WordCounterSpliterator(String string) {
            this.string = string;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {

            action.accept(string.charAt(currentChar));
            currentChar++;
            return currentChar < string.length();
        }

        @Override
        public Spliterator<Character> trySplit() {

            int currentSize = string.length() - currentChar;
            if (currentSize < 10) {
                return null;
            }

            for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
                if (Character.isWhitespace(string.charAt(splitPos))) {
                    Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                    currentChar = splitPos;
                    return spliterator;
                }
            }

            return null;
        }

        @Override
        public long estimateSize() {
            return string.length() - currentChar;
        }

        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
        }
    }

    public static void main(String[] args) {


        final String SENTENCE = "12 23 34 45  56 67  78  89   90";
        WordCount wordCount = new WordCount();
//        System.out.println(wordCount.countWordsIteratively(SENTENCE));

        //如果使用并行流的话就是不对的
//        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
//                .mapToObj(SENTENCE::charAt);
//        System.out.println(wordCount.countWords(stream));

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        System.out.println(wordCount.countWords(stream));
    }
}
