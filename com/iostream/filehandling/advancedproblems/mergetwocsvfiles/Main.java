package org.example.com.iostream.filehandling.advancedproblems.mergetwocsvfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> studentMap = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\student1.csv"));
             BufferedReader br2 = new BufferedReader(new FileReader("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\student2.csv"));
             FileWriter fw = new FileWriter("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\merged_students.csv")) {


            br1.readLine();
            br2.readLine();


            String line1;
            while ((line1 = br1.readLine()) != null) {
                String[] values1 = line1.split(",");
                if (values1.length >= 3) {
                    Student student = new Student(values1[0], values1[1], values1[2]);
                    studentMap.put(values1[0], student);
                }
            }


            String line2;
            while ((line2 = br2.readLine()) != null) {
                String[] values2 = line2.split(",");
                if (values2.length >= 5) {
                    Student student = studentMap.get(values2[0]);
                    if (student != null) {

                        student.setMarks(values2[3]);
                        student.setGrade(values2[4]);
                    } else {

                        student = new Student(values2[0], values2[1], values2[2], values2[3], values2[4]);
                        studentMap.put(values2[0], student);
                    }
                }
            }


            fw.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentMap.values()) {
                fw.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getMarks() + "," + student.getGrade() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing CSV files: " + e.getMessage());
        }
    }
}