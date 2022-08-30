package Reflection.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
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

        Set<Method> getters = new TreeSet<>(new MethodComparatorByName());
        Set<Method> setters = new TreeSet<>(new MethodComparatorByName());

        for (Method method : declaredMethods) {
            if (methodIsGetter(method)
                    && method.getParameterCount() == 0
                    && method.getReturnType() != void.class) {
                getters.add(method);
            } else if (methodIsSetter(method)
                    && method.getParameterCount() == 1
                    && method.getReturnType() == void.class) {
                setters.add(method);
            }
        }

        System.out.println(getters
                .stream()
                .map(g -> String.format("%s will return class %s",
                        g.getName(), g.getReturnType().getName().replace("class", "")))
                .collect(Collectors.joining(System.lineSeparator())));

        System.out.println(setters
                .stream()
                .map(s -> String.format("%s and will set field of class %s",
                        s.getName(), s.getParameterTypes()[0].getName().replace("class", "")))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static boolean methodIsGetter(Method declaredMethod) {
        return declaredMethod.getName().startsWith("get");
    }

    private static boolean methodIsSetter(Method declaredMethod) {
        return declaredMethod.getName().startsWith("set");
    }
}
