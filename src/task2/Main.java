package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer textContainer = new TextContainer();
        Class textContainerClass = TextContainer.class;

        if (textContainerClass.isAnnotationPresent(SaveTo.class)) {
            SaveTo path = (SaveTo) textContainerClass.getAnnotation(SaveTo.class);
            String pathString = path.path();
            Method[] methods = textContainerClass.getMethods();
            for (Method method : methods
            ) {
                if (method.isAnnotationPresent(Saver.class)) {
                    method.invoke(textContainer, pathString);
                }
            }
        }

    }
}
