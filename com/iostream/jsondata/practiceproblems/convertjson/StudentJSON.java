package org.example.com.iostream.jsondata.practiceproblems.convertjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\practiceproblems\\convertjson\\data.json")));

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(content);
            System.out.println("Valid JSON structure: " + jsonNode.toPrettyString());

            JSONObject jsonObject = new JSONObject(content);
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Mahindra", "Corolla", 2022));
            cars.add(new Car("Honda", "Civic", 2021));
            cars.add(new Car("Ford", "Focus", 2020));

            JSONArray carArray = new JSONArray();
            for (Car car : cars) {
                carArray.put(car.toJSON());
            }

            jsonObject.put("cars", carArray);
            System.out.println("JSON with Car List: " + jsonObject.toString(4));
        } catch (Exception e) {
            System.out.println("Invalid JSON structure");
            e.printStackTrace();
        }
    }
}
