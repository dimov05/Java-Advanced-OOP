package ReflectionAndAnnotationExercise.BarracksWars.barracksWars;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.Engine;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
