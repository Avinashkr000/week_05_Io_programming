package org.example.com.iostream.jsondata.handsonpracticeproblems.convertalistofjavaobjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.com.iostream.jsondata.handsonpracticeproblems.convertalistofjavaobjects.Car;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CarListToJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = Arrays.asList(new Car("Toyota", "Corolla", 2020), new Car("Honda", "Civic", 2021));
        String jsonArray = objectMapper.writeValueAsString(cars);
        System.out.println(jsonArray);
    }
}

