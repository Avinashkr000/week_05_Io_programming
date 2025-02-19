package org.example.com.iostream.jsondata.handsonpracticeproblems.convertjsontoxml;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXml {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\convertjsontoxml\\data.json"));

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}


