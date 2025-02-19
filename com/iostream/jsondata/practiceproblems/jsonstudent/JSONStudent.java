package org.example.com.iostream.jsondata.practiceproblems.jsonstudent;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONStudent {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "John Doe");
        student.put("age", 20);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        subjects.put("History");

        student.put("subjects", subjects);

        System.out.println(student.toString(4));
    }
}
