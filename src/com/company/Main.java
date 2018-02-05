package com.company;

import com.company.Handler.SummatorHandler;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static volatile Integer summation = 0;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        double mill = System.currentTimeMillis();

        FileScanner scanner = new FileScanner();
//        List<String> lines = scanner.parse("input.txt");

        //ArrayList<FutureTask<Integer>> taskList = new ArrayList<>();
        ArrayList<Runnable> taskList = new ArrayList<>();

        ArrayList<Thread> threadList = new ArrayList<>();

        File directory = new File("Files/");
        File[] files = directory.listFiles();


      //  SummatorHandler handler = new SummatorHandler(PRr)

        for (int i = 0; i < files.length; i++) {
            final File f = files[i];
            taskList.add((new Runnable() {
                @Override
                public void run() {
                    List<String> lines = scanner.parse(f.getPath());
                    List<Integer> numbers = (Parser.parseLines(lines));
                    Integer a = Summator.sum(numbers, Main.summation);


                    //System.out.println(a);
                }
            }));

            threadList.add(new Thread(taskList.get(i)));
            threadList.get(i).start();
        }




//        for (int i = 0; i < files.length; i++) {
//            final File f = files[i];
//            taskList.add(new FutureTask<>(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    List<String> lines = scanner.parse(f.getPath());
//                    //System.out.println(lines.size());
//                    List<Integer> numbers = (new Parser().parseLines(lines));
//                    Integer a = Summator.sum(numbers, summation);
//                    System.out.println(a);
//                    return a;
//                }
//            }));
//            threadList.add(new Thread(taskList.get(i)));
//            threadList.get(i).start();
//        }


//        for (int i = 0; i < lines.size(); i++) {
//            final String line = lines.get(i);
//            taskList.add(new FutureTask<>(new Callable<Integer>() {
//                @Override
//                public Integer call() {
//                    List<Integer> numbers = (new Parser()).parseLine(line);
//                    return Summator.sum(numbers);
//                }
//            }));
//            threadList.add(new Thread(taskList.get(i)));
//            threadList.get(i).start();
//        }

        /**
         * Вывод времени.
         */
        mill = System.currentTimeMillis() - mill;
      //  System.out.println(mill);


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
