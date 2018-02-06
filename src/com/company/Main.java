package com.company;

import com.company.Handler.SummatorHandler;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.*;

public class Main {
    public static volatile Integer summation = 0;


    public static void main(String[] args) {
        double mill = System.currentTimeMillis();

        FileScanner scanner = new FileScanner();

        ArrayList<Runnable> taskList = new ArrayList<>();

        ArrayList<Thread> threadList = new ArrayList<>();

        File directory = new File("Files/");
        File[] files = directory.listFiles();


        for (int i = 0; i < files.length; i++) {
            final File f = files[i];
            final int num = i;
            taskList.add((new Runnable() {
                @Override
                public void run() {
                    List<String> lines = scanner.parse(f.getPath());
                    List<Integer> numbers = (Parser.parseLines(lines));

                    ISummator summator1 = (ISummator) Proxy.newProxyInstance(
                            ISummator.class.getClassLoader(),
                            new Class[]{ISummator.class},
                            new SummatorHandler());
                    Integer a = summator1.sum(numbers, Main.summation);

                }
            }));

            threadList.add(new Thread(taskList.get(i)));
            threadList.get(i).start();
        }

        /**
         * Вывод времени.
         */
        mill = System.currentTimeMillis() - mill;
        System.out.println("Time: " + mill);


        /**
         * Генерация input файла.
         */
//        PrintWriter writer = new PrintWriter("input4.txt", "UTF-8");
//        Random rand = new Random();
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 10000; j++) {
//                writer.print((rand.nextInt(200)-100) + " ");
//            }
//            writer.println();
//        }
//        writer.close();
    }
}
