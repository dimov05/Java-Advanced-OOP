package ReflectionAndAnnotationExercise.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class clazz = RichSoilLand.class;
        Field[] fields = RichSoilLand.class.getDeclaredFields();
        String input = scanner.nextLine();

        Consumer<Field> printer = f -> System.out.printf("%s %s %s%n",
                Modifier.toString(f.getModifiers()),
                f.getType().getSimpleName(),
                f.getName());

        while (!input.equals("HARVEST")) {
            String finalInput = input;
            Field[] requestedFields = Arrays.stream(fields)
                    .filter(f -> Modifier.toString(f.getModifiers())
                            .equalsIgnoreCase(finalInput))
                    .toArray(Field[]::new);
            if (requestedFields.length != 0) {
                Arrays.stream(requestedFields).forEach(printer);
            } else {
                Arrays.stream(fields).forEach(printer);
            }

            input = scanner.nextLine();
        }
    }

}
