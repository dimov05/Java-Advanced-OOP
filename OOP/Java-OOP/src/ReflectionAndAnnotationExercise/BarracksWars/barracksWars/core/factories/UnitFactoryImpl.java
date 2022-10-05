package ReflectionAndAnnotationExercise.BarracksWars.barracksWars.core.factories;

import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationExercise.BarracksWars.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class<? extends Unit> clazz = (Class<? extends Unit>) Class
				.forName(UnitFactoryImpl.UNITS_PACKAGE_NAME + unitType);
		Constructor<? extends Unit> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);

		return cons.newInstance();
	}
}
