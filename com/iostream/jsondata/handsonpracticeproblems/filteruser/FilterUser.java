package org.example.com.iostream.jsondata.handsonpracticeproblems.filteruser;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;

public class FilterUser {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree("[{\"name\":\"Avinash\", \"age\":30}, {\"name\":\"Kunal\", \"age\":22}]");
        Iterator<JsonNode> elements = rootNode.elements();

        while (elements.hasNext()) {
            JsonNode node = elements.next();
            if (node.path("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}
