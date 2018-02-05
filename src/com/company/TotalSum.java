package com.company;

public class TotalSum {
    private static volatile Integer summation = 0;

    public static Integer getSummation() {
        return summation;
    }

    public static void setSummation(Integer summation) {
        TotalSum.summation = summation;
    }

    public static void add(Integer summation) {
        TotalSum.summation += summation;
    }
}
