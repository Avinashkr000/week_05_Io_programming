package org.example.com.iostream.filehandling.advancedproblems.readlargecsvfiles;

import java.io.*;
import java.nio.file.*;

public class ReadLargeCSVFileEfficiently {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\large.csv");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        int processedCount = 0;
        int chunkSize = 100;

        while ((line = reader.readLine()) != null) {
            if (processedCount % chunkSize == 0 && processedCount > 0) {
                System.out.println("Processed " + processedCount + " records");
            }
            processedCount++;
        }
        System.out.println("Processed " + processedCount + " records");
        reader.close();
    }
}
