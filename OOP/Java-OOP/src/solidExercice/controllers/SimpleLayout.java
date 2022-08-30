package solidExercice.controllers;

import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s",
                date, reportLevel.toString(), message);
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
