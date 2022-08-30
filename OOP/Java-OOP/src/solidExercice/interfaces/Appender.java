package solidExercice.interfaces;

import solidExercice.enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);
    ReportLevel getReportLevel();
}
