package chess.controller.command;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Commands {

    private static final String DELIMITER = " ";
    private final Map<String, Command> commands;

    public Commands(List<Command> commands) {
        this.commands = commands.stream()
                .collect(Collectors.toMap(Command::getCommand, Function.identity()));
    }

    public Command findCommand(String input) {
        List<String> inputs = Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());

        return commands.getOrDefault(inputs.get(0), new IllegalCommand());
    }
}
