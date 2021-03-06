package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Integer> parseLines(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();


        /**
         * LAMBDA HERE!
         */
        lines.forEach(line -> {
            for (String str : line.split(" ")) {
                try {
                    numbers.add(Integer.parseInt(str));
                } catch (Exception ex) {
                    System.err.println("Wrong data format " + line);
                    System.exit(-1);
                }
            }
        });
        return numbers;
//
//        for (String line : lines) {
//            String[] numbersString = line.split(" ");
//
//            for (String s : numbersString) {
//                try {
//                    numbers.add(Integer.parseInt(s));
//                } catch (Exception ex) {
//                    System.err.println("Wrong data format " + line);
//                    System.exit(-1);
//                }
//            }
//        }
//        return numbers;
    }
}
