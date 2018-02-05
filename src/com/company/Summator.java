package com.company;

import com.company.loader.MClassLoader;

import java.util.List;

public class Summator {

    public static int sum(List<Integer> list, Integer summa) {

        for (Integer number : list)
            if (number > 0 && number % 2 == 0) {
                synchronized (TotalSum.getSummation()) {
                    TotalSum.add(number);
                    System.out.println(TotalSum.getSummation());
                }
            }
        return summa;
    }
}
