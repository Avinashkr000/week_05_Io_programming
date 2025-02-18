package org.example.com.iostream.filehandling.advancedproblems.convertjsontocsv;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class JsonToCsv {

    public static void main(String[] args) {
        String jsonFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\convert\\students.json";
        String csvFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\convert\\students.csv";

        try {
            jsonToCsv(jsonFile, csvFile);
            csvToJson(csvFile, "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\convert\\students_from_csv.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(jsonFile));

        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));

   
        writer.write("ID,Name,Age,Grade");
        writer.newLine();

        
        for (JsonNode studentNode : rootNode) {
            String id = studentNode.get("id").asText();
            String name = studentNode.get("name").asText();
            int age = studentNode.get("age").asInt();
            String grade = studentNode.get("grade").asText();

            writer.write(id + "," + name + "," + age + "," + grade);
            writer.newLine();
        }

        writer.close();
        System.out.println("CSV file created successfully.");
    }

    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        String[] headers = reader.readLine().split(",");

       
        StringBuilder jsonOutput = new StringBuilder();
        jsonOutput.append("[");

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            jsonOutput.append("{");

            for (int i = 0; i < values.length; i++) {
                jsonOutput.append("\"" + headers[i] + "\": \"" + values[i] + "\"");
                if (i < values.length - 1) {
                    jsonOutput.append(", ");
                }
            }

            jsonOutput.append("},");
        }

  
        if (jsonOutput.charAt(jsonOutput.length() - 1) == ',') {
            jsonOutput.deleteCharAt(jsonOutput.length() - 1);
        }

        jsonOutput.append("]");

       
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
        writer.write(jsonOutput.toString());
        writer.close();
        reader.close();

        System.out.println("JSON file created successfully.");
    }
}
