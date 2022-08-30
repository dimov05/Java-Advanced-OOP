package solidExercice.controllers;

import solidExercice.interfaces.AppenderFactory;
import solidExercice.interfaces.LayoutFactory;

public class FactoryRepository {
    private static AppenderFactory appenderFactory;
    private static LayoutFactory layoutFactory;

    private FactoryRepository() {
    }

    public static AppenderFactory getAppenderFactory() {
        if (appenderFactory == null) {
            return appenderFactory = new AppenderWorkshop();
        }
        return appenderFactory;
    }

    public static LayoutFactory getLayoutFactory() {
        if(layoutFactory == null) {
            return layoutFactory = new LayoutWorkshop();
        }
        return layoutFactory;
    }
}
