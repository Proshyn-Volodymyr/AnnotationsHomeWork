package task3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassReader {
    public static Object readFromJson(File jsonFile, Class<?> clazz) throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor constructor = clazz.getConstructor();
        Object newObject = constructor.newInstance();
        try (FileReader fileReader = new FileReader(jsonFile)) {

            StringBuilder stringBuilder = new StringBuilder();
            int nextChar;
            while ((nextChar = fileReader.read()) > -1) {
                stringBuilder.append((char) nextChar);
            }
            String parsedString = stringBuilder.toString();
            parsedString = parsedString.replaceAll("[{}\"]", "");
            String[] parsedFields = parsedString.split(",");
            for (String pairs : parsedFields
            ) {
                String[] keyAndValue = pairs.split(":");
                String fieldName = keyAndValue[0].trim();
                String fieldValue = keyAndValue[1].trim();
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                if(!field.isAnnotationPresent(Save.class)){
                    field.set(newObject, null);
                }

                if (fieldType == Integer.class || fieldType == int.class) {
                    field.set(newObject, Integer.parseInt(fieldValue));
                } else if (fieldType == Boolean.class || fieldType == boolean.class) {
                    field.set(newObject, Boolean.valueOf(fieldValue));
                } else {
                    field.set(newObject, fieldValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newObject;
    }
}
