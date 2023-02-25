package task3;

import java.io.*;

public class CustomSerialize {
    public static void main(String[] args) throws NoSuchMethodException {
        Car car = new Car();
        Class carClass = Car.class;
        try {
            ClassWriter.saveToJson(car, "task3.ser");
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
