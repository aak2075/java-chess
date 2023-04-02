package chess.controller.command;

import chess.domain.ChessGame;

public class StatusCommand extends PrintableCommand {

    private static final String command = "status";

    public StatusCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public void execute(String input) {
    }

    @Override
    public double getWhiteScore() {
        return chessGame.calculateWhiteScore();
    }

    @Override
    public double getBlackScore() {
        return chessGame.calculateBlackScore();
    }

    @Override
    public String getCommand() {
        return command;
    }
}
