package org.example.com.iostream.filehandling.intermediateproblems;
import java.io.*;

public class SearchEmployeeByNames {
    public static void main(String[] args) {
        String filePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\intem\\employees.csv";
        String searchName = "Alice";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 3 && values[0].trim().equalsIgnoreCase(searchName)) {
                    System.out.println("Department " + values[1].trim() + ", Salary " + values[2].trim());
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}