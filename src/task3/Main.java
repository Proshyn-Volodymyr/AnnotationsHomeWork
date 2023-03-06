package task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Transmission transmission = new Transmission("manual", 5);
        Car car = new Car(transmission);
        car.setBrand("BMW");
        car.setEngineType("V8");
        car.setPrice(60000);
        car.setAvailable(true);
        car.setModel("X6");


        Class carClass = car.getClass();
        String path = "task3.txt";
        File file = new File(path);
        ClassReader classReader = new ClassReader();
        String jsonString = "";


        try {
            jsonString = ClassWriter.saveToJson(car, path);
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try(FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Object carObject = classReader.readFromJsonFile(file, car);
            System.out.println(carObject);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
