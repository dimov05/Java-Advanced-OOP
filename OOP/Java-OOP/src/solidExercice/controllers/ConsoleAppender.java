package solidExercice.controllers;

import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.Layout;

public class ConsoleAppender extends AbstractAppender {
    public ConsoleAppender(ReportLevel reportLevel, Layout layout) {
        super(reportLevel, layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.getLayout().format(date, reportLevel, message));
        this.incrementAppendCount();
    }

    @Override
    protected String getType() {
        return "ConsoleAppender";
    }
}
