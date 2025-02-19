package org.example.com.iostream.jsondata.handsonpracticeproblems.printallkeyandvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\printallkeyandvalues\\data.json")));

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(content);

            System.out.println("Printing all keys and values:");
            printJson(jsonNode, "");

            JSONObject jsonObject = new JSONObject(content);
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Toyota", "Corolla", 2022));
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

    private static void printJson(JsonNode node, String indent) {
        if (node.isObject()) {
            Iterator<String> fieldNames = node.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                System.out.println(indent + fieldName + ": ");
                printJson(node.get(fieldName), indent + "  ");
            }
        } else if (node.isArray()) {
            for (JsonNode element : node) {
                printJson(element, indent + "  ");
            }
        } else {
            System.out.println(indent + node.asText());
        }
    }
}
