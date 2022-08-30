package solidExercice.core;

import solidExercice.controllers.FactoryRepository;
import solidExercice.enums.ReportLevel;
import solidExercice.interfaces.Appender;
import solidExercice.interfaces.Engine;
import solidExercice.interfaces.InputParser;
import solidExercice.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class EngineImpl implements Engine {
    private boolean isRunning;
    private BufferedReader reader;
    private Logger logger;

    public EngineImpl(BufferedReader reader, Logger logger) {
        this.reader = reader;
        this.logger = logger;

    }


    @Override
    public void run() throws IOException {
        this.isRunning = true;
        String line = reader.readLine();
        addAppenders(Integer.parseInt(line));

        while (this.isRunning) {
            line = reader.readLine();
            String[] parse = InputParser.parse(line);
            if (!parse[0].equals("END")) {
                logMessage(parse);
            }
            this.isRunning = !parse[0].equals("END");
        }

        System.out.println(logger);

    }

    private void addAppenders(int n) throws IOException {
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            ReportLevel reportLevel = tokens.length == 3
                    ? ReportLevel.valueOf(tokens[2].toUpperCase())
                    : ReportLevel.INFO;

            Appender appender = FactoryRepository.getAppenderFactory()
                    .produce(tokens[0], reportLevel,
                            FactoryRepository.getLayoutFactory().produce(tokens[1]));

            logger.addAppender(appender);
        }
    }

    public void logMessage(String[] args) {
        ReportLevel reportLevel = ReportLevel.valueOf(args[0]);
        String date = args[1];
        String message = args[2];

        switch (reportLevel) {
            case INFO -> logger.logInfo(date, message);
            case WARNING -> logger.logWarning(date, message);
            case ERROR -> logger.logError(date, message);
            case CRITICAL -> logger.logCritical(date, message);
            case FATAL -> logger.logFatal(date, message);
            default -> throw new IllegalStateException("Unknown enum value for " + reportLevel);
        }
    }
}
