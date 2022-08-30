package solidExercice.interfaces;

import solidExercice.enums.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
    String getType();
}
