package task3;

import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassReader {
    public  Object readFromJsonFile(File jsonFile, Object object) throws InstantiationException, IllegalAccessException {
        Class classObject = object.getClass();
        try (FileReader fileReader = new FileReader(jsonFile)) {

            StringBuilder stringBuilder = new StringBuilder();
            int nextChar;
            while ((nextChar = fileReader.read()) > -1) {
                stringBuilder.append((char) nextChar);
            }
            String parsedString = stringBuilder.toString();
            try {
                try {
                    readString(parsedString, classObject);

                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    private void readString(String inputString, Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Constructor constructor = clazz.getConstructor();
        Object newObj = constructor.newInstance();
        JSONObject jsonObject = new JSONObject(inputString);
        for (String key : jsonObject.keySet()
        ) {
            Object value = jsonObject.get(key);
            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (value instanceof JSONObject) {
                readString(value.toString(), fieldType);
            }else{
                if (fieldType == Integer.class || fieldType == int.class) {
                    field.set(newObj, Integer.parseInt(value.toString()));
                } else if (fieldType == Boolean.class || fieldType == boolean.class) {
                    field.set(newObj, Boolean.valueOf(value.toString()));
                } else if(fieldType == String.class){
                    field.set(newObj, value.toString());
                }
            }
        }
    }

}
