package org.example.com.iostream.filehandling.advancedproblems.encryptanddecrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.io.*;

public class EncryptDecryptCSV {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456";

    public static void main(String[] args) {
        String csvFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\encryptanddecrypt\\employee_data.csv";
        String encryptedCsvFile = "E:\\cg assing\\Week-05\\src\\main\\java\\org\\example\\com\\iostream\\filehandling\\CsvFiles\\advance\\encryptanddecrypt\\encrypted_employee_data.csv";

        try {
            writeEncryptedCSV(csvFile);
            readDecryptedCSV(csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    public static void writeEncryptedCSV(String csvFile) throws Exception {
        String[][] employeeData = {
                {"1", "John Doe", "john.doe@example.com", "50000"},
                {"2", "Jane Smith", "jane.smith@example.com", "60000"},
                {"3", "Alice Johnson", "alice.johnson@example.com", "45000"}
        };

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"));
        writer.write("ID,Name,Email,Salary");
        writer.newLine();

        for (String[] employee : employeeData) {
            String encryptedEmail = encrypt(employee[2]);
            String encryptedSalary = encrypt(employee[3]);
            writer.write(employee[0] + "," + employee[1] + "," + encryptedEmail + "," + encryptedSalary);
            writer.newLine();
        }

        writer.close();
        System.out.println("Encrypted CSV file created successfully.");
    }

    public static void readDecryptedCSV(String csvFile) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));
        String line;
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",\\s*");
            if (fields.length < 4) continue;

            String id = fields[0];
            String name = fields[1];
            String encryptedEmail = fields[2];
            String encryptedSalary = fields[3];

            try {
                String decryptedEmail = decrypt(encryptedEmail);
                String decryptedSalary = decrypt(encryptedSalary);
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + decryptedEmail + ", Salary: " + decryptedSalary);
            } catch (IllegalArgumentException e) {
                System.err.println("Error decrypting data for ID: " + id);
            }
        }

        reader.close();
    }
}
