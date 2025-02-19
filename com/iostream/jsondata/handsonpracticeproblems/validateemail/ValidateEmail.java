package org.example.com.iostream.jsondata.handsonpracticeproblems.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class ValidateEmail {
    public static void main(String[] args) {

        String schemaStr = """
            {
                "type": "object",
                "properties": {
                    "email": {
                        "type": "string",
                        "format": "email"
                    }
                },
                "required": ["email"]
            }
        """;


        String jsonStr = """
            {
                "email": "test@example.com"
            }
        """;

        try {

            JSONObject jsonSchema = new JSONObject(schemaStr);
            Schema schema = SchemaLoader.load(jsonSchema);


            JSONObject jsonData = new JSONObject(jsonStr);
            schema.validate(jsonData);

            System.out.println(" Email is valid!");
        } catch (Exception e) {
            System.out.println("Invalid Email: " + e.getMessage());
        }
    }
}
