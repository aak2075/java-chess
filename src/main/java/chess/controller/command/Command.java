package chess.controller.command;

public interface Command {

    void execute(String input);

    String getCommand();
}
