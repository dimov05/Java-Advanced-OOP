package solidExercice.controllers;

import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.Appender;
import solidExercice.interfaces.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractLogger implements Logger {
    private List<Appender> appenders;

    public AbstractLogger(Appender... appenders) {
        this.appenders = new ArrayList<>(Arrays.asList(appenders));
    }

    @Override
    public void logInfo(String date, String message) {
        this.callAllAppenders(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        this.callAllAppenders(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        this.callAllAppenders(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String date, String message) {
        this.callAllAppenders(date, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        this.callAllAppenders(date, ReportLevel.FATAL, message);
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    private void callAllAppenders(String date, ReportLevel reportLevel, String message) {
        for (Appender appender : appenders) {
            if (appender.getReportLevel().ordinal() <= reportLevel.ordinal()) {
                appender.append(date, reportLevel, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info")
                .append(System.lineSeparator());
        builder.append(this.appenders.stream().map(Appender::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return builder.toString();
    }
}


