package com.java8.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ss on 2017/9/5.
 */
public class FileProcessor {

//    public static String processFile() throws IOException {
//
//        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/data.txt"))) {
//            return br.readLine();
//        }
//    }

    public interface BufferReaderProcessor {
        String process(BufferedReader bufferedReader) throws IOException;
    }

    public static String processFile(BufferReaderProcessor bufferReaderProcessor) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader((new FileReader("/tmp/data.txt")))) {
            return bufferReaderProcessor.process(bufferedReader);
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println(processFile((BufferedReader bufferReader) -> (bufferReader.readLine())));
        System.out.println(processFile((BufferedReader bufferReader) -> (bufferReader.readLine() + bufferReader.readLine())));
    }
}
