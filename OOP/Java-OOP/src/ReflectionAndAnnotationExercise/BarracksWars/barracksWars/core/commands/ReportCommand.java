package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.UnitFactory;

public class ReportCommand extends CommandImpl {

    protected ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
