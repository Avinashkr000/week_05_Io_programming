package org.example.com.iostream.jsondata.handsonpracticeproblems.iplcensoranalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class IplCensorAnalyzer {

    public static void main(String[] args) throws Exception {
        String jsonInputFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\iplcensoranalyzer\\ipl_data.json";
        String csvInputFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\iplcensoranalyzer\\ipl_data.csv";
        String jsonOutputFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\iplcensoranalyzer\\censored_ipl_data.json";
        String csvOutputFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\jsondata\\handsonpracticeproblems\\iplcensoranalyzer\\censored_ipl_data.csv";

        censorJsonData(jsonInputFile, jsonOutputFile);
        censorCsvData(csvInputFile, csvOutputFile);
    }

    public static void censorJsonData(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> matches = objectMapper.readValue(new File(inputFile), List.class);

        for (Map<String, Object> match : matches) {
            censorMatchData(match);
        }

        objectMapper.writeValue(new File(outputFile), matches);
    }

    public static void censorCsvData(String inputFile, String outputFile) throws IOException {
        try {
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            List<String[]> records = reader.readAll();
            reader.close();

            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                censorRecordData(record);
            }

            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
            writer.writeAll(records);
            writer.close();
        } catch (com.opencsv.exceptions.CsvException e) {
            e.printStackTrace();
        }
    }


    public static void censorMatchData(Map<String, Object> match) {
        if (match.containsKey("team1")) {
            String team1 = (String) match.get("team1");
            match.put("team1", censorTeamName(team1));
        }
        if (match.containsKey("team2")) {
            String team2 = (String) match.get("team2");
            match.put("team2", censorTeamName(team2));
        }
        if (match.containsKey("player_of_the_match")) {
            match.put("player_of_the_match", "REDACTED");
        }
    }

    public static void censorRecordData(String[] record) {
        if (record.length > 2) {
            record[1] = censorTeamName(record[1]);
            record[2] = "REDACTED";
        }
    }

    public static String censorTeamName(String teamName) {
        return teamName.replaceAll("(?<=Mumbai).*", " ***");
    }
}
