package chess.controller.command.action;

import chess.controller.PositionParser;
import chess.domain.ChessGame;
import chess.domain.board.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveCommand extends ActionCommand {

    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private final String command = "move";

    public MoveCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public void execute(String input) {
        List<String> inputs = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        Position source = PositionParser.parse(inputs.get(FIRST_INDEX));
        Position target = PositionParser.parse(inputs.get(SECOND_INDEX));

        chessGame.move(source, target);
    }

    @Override
    public String getCommand() {
        return command;
    }
}
