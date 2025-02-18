package org.example.com.iostream.filehandling.advancedproblems.detectduplicates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {

    public static void main(String[] args) {
        String filePath = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\your_file.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> seen = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                if (seen.contains(id)) {
                    System.out.println(line);
                } else {
                    seen.add(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

