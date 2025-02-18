package org.example.com.iostream.filehandling.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {
    public static void main(String[] args) {
        String filename = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\example.csv";
        int recordCount = countRecords(filename);
        System.out.println("Record count: " + recordCount);
    }

    public static int countRecords(String filename) {
        int recordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine();
            while (reader.readLine() != null) {
                recordCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return recordCount;
    }
}
