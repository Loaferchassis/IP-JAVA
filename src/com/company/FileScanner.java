package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileScanner {
    File inputFile;

    List<String> parse(String filePath) {

        inputFile = new File(filePath);

        List<String> lines = null;
        try {
            lines = FileUtils.readLines(inputFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return lines;
    }
}
