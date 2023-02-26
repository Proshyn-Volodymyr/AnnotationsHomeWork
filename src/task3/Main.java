package task3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(new Transmission("manual", 5));

        Class carClass = car.getClass();
        String path = "task3.ser";
        File file = new File(path);

        car.setBrand("BMW");
        car.setEngineType("V8");
        car.setPrice(50000);
        car.setAvailable(true);
        car.setModel("X5");

        try {
            ClassWriter.saveToJson(car, path);
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }

//        try {
//            Object carObject = ClassReader.readFromJson(file, carClass);
//            System.out.println(carObject);
//        } catch (NoSuchFieldException | InvocationTargetException | InstantiationException | NoSuchMethodException |
//                 IllegalAccessException e) {
//            e.printStackTrace();
//        }

    }
}
