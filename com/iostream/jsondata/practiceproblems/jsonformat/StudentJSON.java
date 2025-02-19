package org.example.com.iostream.jsondata.practiceproblems.jsonformat;

public class StudentJSON {
    public static void main(String[] args) {
        Car car = new Car("Mahindra", "Avinash", 2022);
        System.out.println(car.toJSON().toString(4));
    }
}
