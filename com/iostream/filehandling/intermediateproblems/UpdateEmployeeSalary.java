package org.example.com.iostream.filehandling.intermediateproblems;
import java.io.*;
import java.util.*;

public class UpdateEmployeeSalary {
    public static void main(String[] args) {
        String inputFilePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\intem\\employees.csv";
        String outputFilePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\intem\\updated_employees.csv";

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
                if (values.length >= 3 && values[1].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(values[2].trim());
                    salary *= 1.10;
                    values[2] = String.format("%.2f", salary);
                }
                employeeData.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : employeeData) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Updated employee salaries saved to " + outputFilePath);
    }
}
