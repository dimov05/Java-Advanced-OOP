package InterfaceAndAbstractionExercise.MilitaryElite.Engine;

import InterfaceAndAbstractionExercise.MilitaryElite.Engine.Army;
import InterfaceAndAbstractionExercise.MilitaryElite.Engine.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandParser {
    private List<String> commandWithTokens;
    private Command command;

    public CommandParser(List<String> commandWithTokens) {
        this.commandWithTokens = commandWithTokens;
        this.command = new Command();
    }

    public Army parseCommands() {
        for (String commandLine : this.commandWithTokens) {
            String[] commandTokens = commandLine.split("\\s+");
            this.command.execute(commandTokens[0], Arrays.stream(commandTokens)
                    .skip(1).collect(Collectors.toList()));
        }
        return this.command.getARMY();
    }
}
