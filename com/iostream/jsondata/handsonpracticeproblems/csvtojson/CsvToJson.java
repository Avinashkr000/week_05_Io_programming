package org.example.com.iostream.jsondata.handsonpracticeproblems.csvtojson;
import com.opencsv.CSVReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\csvtojson\\data.csv"));
        List<String[]> records = csvReader.readAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(records);
        System.out.println(json);
    }
}