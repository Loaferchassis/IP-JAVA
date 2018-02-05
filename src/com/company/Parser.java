package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> parseLine(String line) {
        List<Integer> numbers = new ArrayList<>();
        String[] numbersString = line.split(" ");

        for (String s : numbersString)
            try {
                numbers.add(Integer.parseInt(s));
            } catch (Exception ex) {
                System.err.println("Wrong data format " + s);
                System.exit(-1);
            }
        return numbers;
    }

    public static List<Integer> parseLines(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            String[] numbersString = line.split(" ");
            for (String s : numbersString) {
                try {
                    numbers.add(Integer.parseInt(s));
                } catch (Exception ex) {
                    System.err.println("Wrong data format " + line);
                    System.exit(-1);
                }
            }
        }
        return numbers;
    }
}
