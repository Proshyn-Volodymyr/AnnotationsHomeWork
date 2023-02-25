package task3;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class ClassWriter {
    public static void saveToJson(Object object, String path) throws IOException, IllegalAccessException {
        FileWriter fileWriter = new FileWriter(path);
        Field[] fields = object.getClass().getDeclaredFields();
        fileWriter.write("{" + System.lineSeparator());
        for (int i = 0; fields.length > i; i++
        ) {
            Field field = fields[i];
            field.setAccessible(true);
            Class fieldType = field.getType();
            Object fieldValue = field.get(object);
            if (field.isAnnotationPresent(Save.class)) {
                fileWriter.write("\"" + field.getName() + "\"" + ": ");
                if (fieldValue == null) {
                    fileWriter.write("null");
                } else if (fieldType == char.class || fieldType == Character.class) {
                    fileWriter.write("\"" + fieldValue + "\"");
                } else if (fieldType == String.class) {
                    fileWriter.write("\"" + fieldValue + "\"");
                } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                    fileWriter.write(fieldValue.toString());
                } else if (fieldType == int.class || fieldType == Integer.class) {
                    fileWriter.write(fieldValue.toString());
                } else {
                    saveToJson(fieldValue, path);
                }
                if (fields.length - 1 > i) {
                    fileWriter.write(",");
                }
                    fileWriter.write(System.lineSeparator());
            }
        }
        fileWriter.write("}");
        fileWriter.close();
    }
}
