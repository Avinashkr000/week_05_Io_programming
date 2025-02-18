package org.example.com.iostream.filehandling.intermediateproblems;


import java.io.*;
import java.util.*;

public class SortEmployeesBySalary {
    public static void main(String[] args) {
        String inputFilePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\intem\\employees.csv";

        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (isFirstLine) {
                    isFirstLine = false;
                    employeeData.add(values);
                    continue;
                }
                employeeData.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        employeeData.sort((a, b) -> {
            try {
                double salaryA = Double.parseDouble(a[2].trim());
                double salaryB = Double.parseDouble(b[2].trim());
                return Double.compare(salaryB, salaryA);
            } catch (NumberFormatException e) {
                return 0;
            }
        });

        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
            System.out.println(String.join(", ", employeeData.get(i)));
        }
    }
}