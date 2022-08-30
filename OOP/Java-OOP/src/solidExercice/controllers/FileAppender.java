package solidExercice.controllers;

import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.File;
import solidExercice.interfaces.Layout;

public class FileAppender extends AbstractAppender {
    private File file;

    public FileAppender(ReportLevel reportLevel, Layout layout) {
        super(reportLevel, layout);
        this.file = new LogFile();
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String formatted = this.getLayout().format(date, reportLevel, message);
        this.file.write(formatted);
        super.incrementAppendCount();
    }

    @Override
    protected String getType() {
        return "FileAppender";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d",
                this.file.getSize());
    }
}
