package Reflection.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static class MethodComparatorByName implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) {
        Class<?> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Field[] publicFields = clazz.getFields();
        Method[] publicMethods = clazz.getMethods();

        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> getters = new TreeSet<>(new MethodComparatorByName());
        Set<Method> setters = new TreeSet<>(new MethodComparatorByName());

        fields.addAll(Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .collect(Collectors.toList()));

        for (Method method : declaredMethods) {
            if (methodIsGetter(method)
                    && !Modifier.isPublic(method.getModifiers())) {
                getters.add(method);
            } else if (methodIsSetter(method)
                    && !Modifier.isPrivate(method.getModifiers())) {
                setters.add(method);
            }
        }


        System.out.println(fields.stream()
                .map(f -> f.getName() + " must be private!")
                .collect(Collectors.joining(System.lineSeparator())));

        System.out.println(getters
                .stream()
                .map(g -> String.format("%s have to be public!",
                        g.getName()))
                .collect(Collectors.joining(System.lineSeparator())));

        System.out.println(setters
                .stream()
                .map(s -> String.format("%s have to be private!",
                        s.getName()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static boolean methodIsGetter(Method declaredMethod) {
        return declaredMethod.getName().startsWith("get");
    }

    private static boolean methodIsSetter(Method declaredMethod) {
        return declaredMethod.getName().startsWith("set");
    }
}
