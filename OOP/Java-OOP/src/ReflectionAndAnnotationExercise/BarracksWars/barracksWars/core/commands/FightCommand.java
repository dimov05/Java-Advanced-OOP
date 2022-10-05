package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class FightCommand extends CommandImpl {
    protected FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}
