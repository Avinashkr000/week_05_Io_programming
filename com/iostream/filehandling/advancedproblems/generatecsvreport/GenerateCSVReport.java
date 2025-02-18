package org.example.com.iostream.filehandling.advancedproblems.generatecsvreport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVReport {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/employee"; 
        String dbUser = "root";
        String dbPassword = "test";
        String csvFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\employees.csv";

        fetchAndWriteToCSV(dbUrl, dbUser, dbPassword, csvFile);
    }

    public static void fetchAndWriteToCSV(String dbUrl, String dbUser, String dbPassword, String csvFile) {
        
        String query = "SELECT employee_id, name, email, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            System.out.println("Connected to database successfully!");

      
            writer.write("Employee ID,Name,Email,Salary");
            writer.newLine();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");  
                String name = rs.getString("name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");

                writer.write(employeeId + "," + name + "," + email + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated successfully at: " + csvFile);

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("File Writing Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}