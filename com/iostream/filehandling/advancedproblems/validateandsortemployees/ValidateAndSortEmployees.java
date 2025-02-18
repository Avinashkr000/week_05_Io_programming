package org.example.com.iostream.filehandling.advancedproblems.validateandsortemployees;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateAndSortEmployees {
    public static void main(String[] args) {
        String inputFilePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\employees.csv";

        List<String[]> employeeData = new ArrayList<>();
        List<String[]> invalidData = new ArrayList<>();

        String emailRegex = "[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

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
                if (values.length < 4 || !emailPattern.matcher(values[3].trim()).matches() || !phonePattern.matcher(values[4].trim()).matches()) {
                    invalidData.add(values);
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

        if (!invalidData.isEmpty()) {
            System.out.println("Invalid rows found:");
            for (String[] row : invalidData) {
                System.out.println(String.join(", ", row) + " - Error: Invalid email or phone number");
            }
        }
    }
}
