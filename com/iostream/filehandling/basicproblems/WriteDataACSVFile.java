package org.example.com.iostream.filehandling.basicproblems;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDataACSVFile {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\Employees.csv"))) {
            pw.println("ID,Name,Department,Salary");
            for (int i = 1; i <= 5; i++) {
                pw.println(i + ",Avinash kumar," + (i % 3 == 0 ? "IT" : i % 2 == 0 ? "Software" : "Finance") + "," + (i * 10000));
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}