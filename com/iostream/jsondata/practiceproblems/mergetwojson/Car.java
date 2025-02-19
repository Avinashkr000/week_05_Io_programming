package org.example.com.iostream.jsondata.practiceproblems.mergetwojson;

import org.json.JSONObject;

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public JSONObject toJSON() {
        JSONObject carJson = new JSONObject();
        carJson.put("make", make);
        carJson.put("model", model);
        carJson.put("year", year);
        return carJson;
    }
}

