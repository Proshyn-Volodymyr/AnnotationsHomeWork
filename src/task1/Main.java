package task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class testClass = TestAnnWithParams.class;
        Method[] methods = testClass.getMethods();
        TestAnnWithParams testAnnWithParams = new TestAnnWithParams();
        for (Method method : methods
        ) {
            if (method.isAnnotationPresent(MethodArgsProvider.class)) {
                MethodArgsProvider methodArgsProvider = method.getAnnotation(MethodArgsProvider.class);
                try {
                    method.invoke(testAnnWithParams, methodArgsProvider.param1(), methodArgsProvider.param2());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
