package task3;

import java.io.IOException;
import java.lang.reflect.Field;

public class ClassWriter {
    public static <T> String saveToJson(T object, String path) throws IOException, IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{" + System.lineSeparator());
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Class fieldType = field.getType();
            Object fieldValue = field.get(object);
            if (field.isAnnotationPresent(Save.class)) {
                stringBuilder.append("\"" + field.getName() + "\"" + ": ");
                if (fieldValue == null) {
                    stringBuilder.append("null");
                } else if (fieldType == char.class || fieldType == Character.class) {
                    stringBuilder.append("\"" + fieldValue + "\"");
                } else if (fieldType == String.class) {
                    stringBuilder.append("\"" + fieldValue + "\"");
                } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                    stringBuilder.append(fieldValue);
                } else if (fieldType == int.class || fieldType == Integer.class) {
                    stringBuilder.append(fieldValue);
                } else {
                    stringBuilder.append(saveToJson(fieldValue, path));
                }
                if (fields.length - 1 > i) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(System.lineSeparator());
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
