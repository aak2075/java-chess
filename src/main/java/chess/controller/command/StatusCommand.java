package chess.controller.command;

import chess.domain.ChessGame;

public class StatusCommand extends AbstractCommand{

    public static final String command = "status";

    public StatusCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public void execute(String input) {
        chessGame.calculateWhiteScore();
        chessGame.calculateBlackScore();
    }

    @Override
    public String getCommand() {
        return command;
    }
}
