package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String command = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1) + "Command";

        Class<? extends Executable> commandClass =
                (Class<? extends Executable>) Class.forName(CommandInterpreterImpl.COMMAND_PACKAGE + command);
        Constructor cons = commandClass.getDeclaredConstructor(String[].class);
        cons.setAccessible(true);
        Executable executable = (Executable) cons.newInstance(new Object[]{data});

        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] thisCommandImpl = this.getClass().getDeclaredFields();

        for (Field executableField : executableFields) {
            if (executableField.isAnnotationPresent(Inject.class)) {
                for (Field field : thisCommandImpl) {
                    if (executableField.getType().equals(field.getType())) {
                        executableField.setAccessible(true);
                        executableField.set(executable, field.get(this));
                    }
                }
            }
        }

        return executable;
    }
}
