package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
