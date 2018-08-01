package com.jtemp.test.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Utils {

    private static void gbk2utf8(File file) {
        if (file.isDirectory()) {
            try {
                Files.list(file.toPath()).forEach(p -> gbk2utf8(p.toFile()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.getName().toLowerCase().endsWith(".txt")) {
            try {
                List<String> lines = Files.readAllLines(file.toPath(), Charset.forName("GBK"));
                System.out.println(lines);
                Files.write(file.toPath(), lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        gbk2utf8(new File("/Users/ZMS/Downloads/ei.txt"));

    }

}
