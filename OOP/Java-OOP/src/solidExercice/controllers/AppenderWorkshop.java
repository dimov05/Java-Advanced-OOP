package solidExercice.controllers;

import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.Appender;
import solidExercice.interfaces.AppenderFactory;
import solidExercice.interfaces.Layout;

public class AppenderWorkshop implements AppenderFactory {
    @Override
    public Appender produce(String type, ReportLevel reportLevel, Layout layout) {


        return switch (type) {
            case "ConsoleAppender" -> new ConsoleAppender(reportLevel, layout);
            case "FileAppender" -> new FileAppender(reportLevel, layout);
            default -> throw new IllegalStateException("Not valid type of appender for" + type + " param");
        };
    }
}
