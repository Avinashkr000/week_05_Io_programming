package org.example.com.iostream.filehandling.intermediateproblems;

import java.io.*;
import java.util.*;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\StudentMarks.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    try {
                        int marks = Integer.parseInt(values[1].trim());
                        if (marks > 80) {
                            System.out.println(line);
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}