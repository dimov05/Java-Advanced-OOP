package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends CommandImpl {
    protected AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
