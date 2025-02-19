package org.example.com.iostream.jsondata.practiceproblems.mergetwojson;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\practiceproblems\\mergetwojson\\data.json")));
            JSONObject jsonObject = new JSONObject(content);

            Car car = new Car("Toyota", "Corolla", 2022);
            JSONObject carJson = car.toJSON();

            JSONObject mergedJson = new JSONObject(jsonObject.toString()); // Corrected copy

            for (Object key : carJson.keySet()) {
                mergedJson.put((String) key, carJson.get((String) key));
            }

            System.out.println("Merged JSON: " + mergedJson.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}