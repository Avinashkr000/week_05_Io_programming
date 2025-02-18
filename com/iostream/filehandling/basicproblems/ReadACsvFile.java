package org.example.com.iostream.filehandling.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadACsvFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\Student.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("ID: " + values[0] + ", Name: " + values[1] + ", Age: " + values[2] + ", Marks: " + values[3]);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}