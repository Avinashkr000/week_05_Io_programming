package org.example.com.iostream.jsondata.handsonpracticeproblems.mergetwojsonfiles;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class Merge {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json1 = objectMapper.readTree(new File("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\mergetwojsonfiles\\file1.json"));
        JsonNode json2 = objectMapper.readTree(new File("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\mergetwojsonfiles\\file2.json"));

        ((ObjectNode) json1).setAll((ObjectNode) json2);

        System.out.println(json1.toString());
    }
}


