package ReflectionAndAnnotationExercise.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> cons = BlackBoxInt.class.getDeclaredConstructor();
        cons.setAccessible(true);
        BlackBoxInt test = cons.newInstance();
        Method[] methods = test.getClass().getDeclaredMethods();
        Field innerValue = test.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equalsIgnoreCase(command))
                    .findFirst().orElse(null);
            method.setAccessible(true);
            method.invoke(test, value);

            System.out.println(innerValue.get(test));

            input = scanner.nextLine();
        }
    }
}
