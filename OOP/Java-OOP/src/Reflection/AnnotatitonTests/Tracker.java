package Reflection.AnnotatitonTests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Author(name = "George")
public class Tracker {
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    private static void printMethodsByAuthor(Class<Tracker> trackerClass) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = Tracker.class.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name())
                        .add(method.getName() + "()");
            }
        }
        methodsByAuthor.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
