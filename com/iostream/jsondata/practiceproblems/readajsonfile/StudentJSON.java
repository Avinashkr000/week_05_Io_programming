package org.example.com.iostream.jsondata.practiceproblems.readajsonfile;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\practiceproblems\\readajsonfile\\Data.json")));
            JSONObject jsonObject = new JSONObject(content);
            String name = jsonObject.optString("name", "N/A");
            String email = jsonObject.optString("email", "N/A");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
