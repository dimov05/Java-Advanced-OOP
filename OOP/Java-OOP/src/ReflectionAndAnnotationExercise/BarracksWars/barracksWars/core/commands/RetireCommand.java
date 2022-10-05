package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends CommandImpl {
    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            this.getRepository().removeUnit(this.getData()[1]);
            return this.getData()[1] + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
