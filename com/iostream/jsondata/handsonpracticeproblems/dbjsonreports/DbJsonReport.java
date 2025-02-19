package org.example.com.iostream.jsondata.handsonpracticeproblems.dbjsonreports;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.io.IOException;

public class DbJsonReport {
    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "test");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        ObjectMapper objectMapper = new ObjectMapper();
        while (rs.next()) {
            String json = objectMapper.writeValueAsString(rs);
            System.out.println(json);
        }
        conn.close();
    }
}

