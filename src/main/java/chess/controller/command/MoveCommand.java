package chess.controller.command;

import chess.controller.PositionParser;
import chess.domain.ChessGame;
import chess.domain.board.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveCommand extends AbstractCommand {

    private final String command = "move";

    public MoveCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public void execute(String input) {
        List<String> inputs = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        // validate(input);

        Position source = PositionParser.parse(inputs.get(1));
        Position target = PositionParser.parse(inputs.get(2));

        chessGame.move(source, target);
    }

    @Override
    public String getCommand() {
        return command;
    }
}
