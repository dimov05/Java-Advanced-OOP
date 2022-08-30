package solidExercice.controllers;

import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.Appender;
import solidExercice.interfaces.Layout;

public abstract class AbstractAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int appendsCount;

    public AbstractAppender(ReportLevel reportLevel, Layout layout) {
        this.reportLevel = reportLevel;
        this.layout = layout;
    }


    public AbstractAppender(Layout layout) {
        this(ReportLevel.INFO, layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {

    }

    protected Layout getLayout() {
        return layout;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Appender type: ");
        builder.append(this.getType())
                .append(", Layout type: ")
                .append(this.layout.getType())
                .append(", Report level: ")
                .append(String.format("%s, ",
                        this.getReportLevel().toString()))
                .append("Messages appended: ")
                .append(String.format("%d",
                        this.appendsCount));
        return builder.toString();
    }

    protected void incrementAppendCount() {
        this.appendsCount++;
    }
}
