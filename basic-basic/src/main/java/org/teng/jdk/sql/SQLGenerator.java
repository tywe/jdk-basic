package org.teng.jdk.sql;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/9/9
 */
public class SQLGenerator {


    public static List<String> getData() throws IOException {
        String filePath = "C:\\Users\\dell\\Desktop";

        File file = new File(filePath);

        BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        List<String> strings = new ArrayList<>();
        while ((line = breader.readLine()) != null) {
            strings.add(line);
        }

        return strings;
    }

    public static void listTest(List<String> strList) {
        int size = strList.size();
        int termToImport = 3;
        int end = 0;
        for (int start = 0; start < size; start = start + termToImport) {
            if (size < start + termToImport) {
                end = size;
            } else {
                end = start + termToImport;
            }
            System.out.println(strList.subList(start, end));
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 19; i++) {
            strings.add(String.valueOf(i));
        }

        System.out.println(strings);
        listTest(strings);
    }
}
